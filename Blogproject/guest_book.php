

<div class="card mb-3">

    <div class="card-header">
        Przykład: Pobranie danych z tabeli guest_book z bazy danych
    </div>
    <div class="card-body">

        <?php
        if (!defined('IN_INDEX')) { exit("Nie można uruchomić tego pliku bezpośrednio."); }
        /*
        Aby skorzystać z przekazania danych metoda POST, należy ustawić atrybut method w elemencie <form>.
        Dane nie sa wowczas przekazywane w adresie URL tak jak w metodzie GET, ale przesyłane są w ciele
        zapytania, na poziomie sieciowym (jest to niewidoczne dla użytkownika). Metoda POST według domyślnych
        konfiguracji serwerow www pozwala na przesyłanie większej liczby znaków niż metoda GET oraz danych
        niestandardowych, takich jak na przykład pliki. Z tego powodu formularze HTML idealnie współgrają
        z tą metoda. Należy jednak zauważyć, ze atrybut method możemy również ustawić na GET, wówczas pola
        z formularza trafią do adresu URL.

        Dostęp do danych przekazanych metodą POST jest możliwy za pomocą tablicy superglobalnej $_POST.
        */
          if (isset($_POST['opinion'])) {
            $opinion = $_POST['opinion'];
            $ip=$_SERVER['REMOTE_ADDR'];

            if (mb_strlen($opinion) >= 5 && mb_strlen($opinion) <= 500) {

                $recaptcha = new \ReCaptcha\ReCaptcha($config['recaptcha_private']);
                $resp = $recaptcha->verify($_POST['g-recaptcha-response'], $_SERVER['REMOTE_ADDR']);
                if ($resp->isSuccess()) {
                $stmt = $dbh->prepare("INSERT INTO guest_book (opinion, ip, created) VALUES (:opinion, :ip, NOW())");
                $stmt->execute([':opinion' => $opinion, ':ip' => $ip]);
                print '<p style="font-weight: bold; color: green;">Dane zostały dodane do bazy.</p>';
                } else {
                    $errors = $resp->getErrorCodes();
                    print '<p style="font-weight: bold; color: red;">Podane dane są nieprawidłowe.</p>';
                }


            } else {
                print '<p style="font-weight: bold; color: red;">Podane dane są nieprawidłowe.</p>';
            }

        }




          if (isset($_GET["delete"])) {

            $id=$_GET['delete'];
            $ip=$_SERVER['REMOTE_ADDR'];

            $stmt = $dbh->prepare("DELETE FROM guest_book WHERE id = :id AND ip = :ip");
            $stmt->execute([':ip' => $ip, ':id' => $id]);

          }



        ?>

  <form action="/guest_book" method="POST">

        <textarea class="form-control" name="opinion" id="opinion" rows="3"></textarea>
        <div class="g-recaptcha" data-sitekey="<?php print $config['recaptcha_public'] ?>" ></div>
        <input type="submit" value="Dodaj">

  </form>


        <table class="table table-striped mt-3" id="moja-tabelka">
          <thead>
            <tr id="wiersz-naglowka">
              <th scope="col">ID</th>
              <th scope="col" >Opinia</th>
              <th scope="col" >Opcja</th>
            </tr>
          </thead>
          <tbody>

            <?php
            $ip=$_SERVER['REMOTE_ADDR'];

            $stmt = $dbh->prepare("SELECT id, opinion,ip FROM guest_book");
            $stmt->execute([':ip' => $ip]);

            while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {

            if($row['ip']==$_SERVER['REMOTE_ADDR'])
                print '
                <tr>
                  <td>' . intval($row['id']) . '</td>
                  <td>' . htmlspecialchars($row['opinion'], ENT_QUOTES | ENT_HTML401, 'UTF-8') . '</td>
                  <td><a href="/guest_book/delete/'.$row['id'].'"><button>USUN</button></a></td>
                  <td></td>
                </tr>';
            else
                print '
                <tr>
                  <td>' . intval($row['id']) . '</td>
                  <td>' . htmlspecialchars($row['opinion'], ENT_QUOTES | ENT_HTML401, 'UTF-8') . '</td>
                  <td></td>
                  <td></td>
                </tr>';
            }

            ?>
          </tbody>
        </table>
    </div>
</div>

