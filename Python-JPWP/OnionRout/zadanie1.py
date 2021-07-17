from cryptography.hazmat.primitives import padding


# ---- TO MODIFY -----
def split_to_packets(message):
    padder = padding.PKCS7(1024).padder()
    padded_data = padder.update(message)
    padded_data += padder.finalize()
    data_list = []
    for i in range(len(padded_data) // 128):
        k = 128 * i
        data_list.append(padded_data[k:k + 128])
    return data_list


def remove_padding(data):
    try:
        unpadder = padding.PKCS7(1024).unpadder()
        message = unpadder.update(data)
        message += unpadder.finalize()
        return message
    except ValueError:
        return data


# ---- END -----

if __name__ == "__main__":
    message = b"Lorem Ipsum jest tekstem stosowanym jako przykladowy wypelniacz w przemysle poligraficznym. Zostal po raz pierwszy uzyty w XV w. przez nieznanego drukarza do wypelnienia tekstem probnej ksiazki. Piec wiekow pozniej zaczal byc uzywany przemysle elektronicznym, pozostajac praktycznie niezmienionym. Spopularyzowal sie w latach 60."
    packets = split_to_packets(message)
    message_again = remove_padding(b"".join(packets))
    print("packets =", packets, end="\n-------------------\n")
    print("message_again =", message_again, end="\n-------------------\n")
    print("wynik:", "jest w pyte" if message_again == message and all(
        len(part) == 128 for part in packets) else "średnio na jeża")
