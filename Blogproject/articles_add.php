  <form action="/articles_add" method="POST">

        <input type="text" placeholder="Tytuł" name ="title" >
        </br>
        </br>
        <textarea class="art-editor" style="height: 300px" name="content"></textarea>
        </br>
        <input type="submit" value="Dodaj" name ="add">
  </form>


    <?php
       if (isset($_POST['add'])) {


            $user_id=$_SESSION['id'];
            $content=$_POST['content'];
            $title=$_POST['title'];

            if (mb_strlen($content) > 0 && mb_strlen($title) > 0 ) {

                      $stmt = $dbh->prepare('
                      INSERT INTO articles (
                      user_id, title, content, created
                      ) VALUES (
                      :user_id, :title, :content, NOW()
            )
        ');
                $stmt->execute([':user_id' => $user_id, ':title' => $title,':content' => $content]);
                print '<span style="color: green;">Poprawnie dodano nowy artykuł.</span>';
            }
          else {
          print '<span style="color: red;">Wypełnij pole tytuł i napisz artykuł.</span>';
          }



        }



    ?>
