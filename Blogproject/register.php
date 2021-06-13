
        <form method="POST" action="/register" id="formularz">
        <table id="daneosobowe">
                <tr>
                <td> <input name="my_email" type="text" placeholder="Email"> </td> <br />
                </tr>
                <br/>
                <tr><td></td></tr>
                <tr>
                <td> <input name="my_password" type="password" placeholder="Hasło"> </td> <br />
                </tr>
                <br/>
                </table>
                <br/>
                <div class="g-recaptcha" data-sitekey="<?php print $config['recaptcha_public'] ?>" ></div>
                <br/>
                <input type="submit" form="formularz" value="Załóż konto" name ="add"> </input>
        </form>




    <?php
       if (isset($_POST['add'])) {
            $my_email = $_POST['my_email'];
            $my_password=$_POST['my_password'];
            $recaptcha = new \ReCaptcha\ReCaptcha($config['recaptcha_private']);
            $resp = $recaptcha->verify($_POST['g-recaptcha-response'], $_SERVER['REMOTE_ADDR']);

            if (preg_match('/^[a-zA-Z0-9\-\_\.]+\@[a-zA-Z0-9\-\_\.]+\.[a-zA-Z]{2,5}$/D', $my_email)) {
                if ($resp->isSuccess()) {

                    try {
                      $stmt = $dbh->prepare('
                      INSERT INTO users (
                      id, email, password, created
                      ) VALUES (
                      null, :email, :password, NOW()
            )
        ');
                $password_hash=password_hash($my_password, PASSWORD_DEFAULT);
                $stmt->execute([':email' => $my_email, ':password' => $password_hash]);
                 print '<span style="color: green;">Konto zostało założone.</span>';
           } catch (PDOException $e) {
             print '<span style="color: red;">Podany adres email jest już zajęty.</span>';
           }
                } else {
                    print '<p style="font-weight: bold; color: red;">Podane dane są nieprawidłowe.</p>';
                }

            } else {
                print '<p style="font-weight: bold; color: red;">Podane dane są nieprawidłowe.</p>';
            }

        }
    ?>

