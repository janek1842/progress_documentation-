<?php

if (isset($_GET['show']) && intval($_GET['show']) > 0) {

    $id = intval($_GET['show']);
    // podstrona /articles_list/show/<id>,
    // tutaj wyswietlamy tytul i tresc artykulu, ktorego ID mamy w zmiennej $id
    ?>
     <td><a href="/articles_list"><button>Powrót do poprzedniej strony</button></a></td>
     </br>
     </br>
          <table class="table table-striped mt-10" id="moja-tabelka">
          <thead>
            <tr id="wiersz-naglowka">
              <th scope="col">Tytuł</th>
              <th scope="col" >Edycja</th>
            </tr>
          </thead>
          <tbody>
          </br>
          </br>

<?php

     $stmt = $dbh->prepare("SELECT * FROM articles WHERE id = :id");
     $stmt->execute([':id' => $id]);
     $row = $stmt->fetch(PDO::FETCH_ASSOC);

     if($row)
     {

 print '
     <tr>
     <td>' . ($row['title']) . '</td>
     <td>' . ($row['content']) . '</td>
     </tr>';

}
else{
  print '<span style="color: red;">Nie ma takiego artykułu</span>';
}

?>

</tbody>
</table>

<?php

} elseif (isset($_GET['edit']) && intval($_GET['edit']) > 0) {

    $id = intval($_GET['edit']);

    if (isset($_POST['title']) && isset($_POST['content'])) {

        // tutaj zapisujemy zmiany w artykule $id, zakladajac, ze w formularzu edycji
        // dla tytulu i tresci nadano atrybuty name="title" oraz name="content",
        // przed zapisem nalezy upewnic sie, ze zalogowany uzytkownik jest autorem artykulu

     $stmt = $dbh->prepare("SELECT * FROM articles WHERE id = :id");
     $stmt->execute([':id' => $id]);
     $row = $stmt->fetch(PDO::FETCH_ASSOC);

     if($row)
     {
       $user_id=$_SESSION['id'];
       $content=$_POST['content'];
       $title=$_POST['title'];

            if (mb_strlen($content) > 0 && mb_strlen($title) > 0 ) {
                $stmt = $dbh->prepare("UPDATE articles SET title = :title, content = :content WHERE id = :id AND user_id = :user_id");
                $stmt->execute([':id' => $id,':user_id' => (isset($_SESSION['id']) ? $_SESSION['id'] : 0), ':title' => $title,':content' => $content]);
                ?>
                </br>
                </br>
                <?php
                print '<span style="color: green;">Poprawnie zaaktualizowano artykuł.</span>';
            }
          else
		  {
          print '<span style="color: red;">Wypełnij pole tytuł i napisz artykuł.</span>';
          }
	}
else{
  print '<span style="color: red;">Nie ma takiego artykułu</span>';
}
	}

?>

     <td><a href="/articles_list"><button>Powrót do poprzedniej strony</button></a></td>
     </br>
     </br>

        <form action="/articles_list/edit/<?php print $id; ?> " method="POST">
<?php
     $stmt = $dbh->prepare("SELECT * FROM articles WHERE id = :id");
     $stmt->execute([':id' => $id]);
     $row = $stmt->fetch(PDO::FETCH_ASSOC);
?>


        <input type="text" placeholder="Tytuł" name ="title" value="<?php print $row['title'] ?>">
        </br>
        </br>
        <textarea class="art-editor" style="height: 300px" name="content" ><?php print $row['content'] ?> </textarea>
        </br>
        <input type="submit" value="Zapisz" name ="add">

       </form>

<?php


} else {

    if (isset($_GET['delete']) && intval($_GET['delete']) > 0) {

        $id = intval($_GET['delete']);

        // tutaj usuwamy artykul, ktorego ID mamy w zmiennej $id,
        // przed usunieciem nalezy upewnic sie, ze zalogowany uzytkownik jest autorem artykulu

         $stmt = $dbh->prepare("DELETE FROM articles WHERE id = :id AND user_id = :user_id");
         $stmt->execute([':id' => $id,':user_id' => (isset($_SESSION['id']) ? $_SESSION['id'] : 0) ]);

    }


 ?>

      <table class="table table-striped mt-10" id="moja-tabelka">
          <thead>
            <tr id="wiersz-naglowka">
              <th scope="col">Tytuł</th>
              <th scope="col" >Edycja</th>
              <th scope="col" >Usuwanie</th>
            </tr>
          </thead>
          <tbody>

            <?php

            $stmt = $dbh->prepare("SELECT * FROM articles ORDER BY id DESC");
            $stmt->execute();

          while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {

            if(isset($_SESSION['id']) && $row['user_id']==$_SESSION['id']   ){
                print '
                <tr>
                  <td><a href="/articles_list/show/'.$row['id'].'">' . htmlspecialchars($row['title'], ENT_QUOTES | ENT_HTML401, 'UTF-8') . '</a></td>
                  <td><a href="/articles_list/edit/'.$row['id'].'"><button>Edytuj</button></a></td>
                  <td><a href="/articles_list/delete/'.$row['id'].'"><button>Usuń</button></a></td>
                </tr>';
                }
            else{
             print '
                <tr>
                  <td><a href="/articles_list/show/'.$row['id'].'">' . ($row['title']) . '</a></td>
                  <td></td>
                  <td></td>
                </tr>';
                }
            }

            ?>
      </tbody>
      </table>
<?php
}


?>
