## Przygotowanie środowiska
1. Pobierz i zainstaluj Android Studio: https://developer.android.com/studio
2. Pobierz kod projektu klikając na zielony przycisk [<> Code] -> [Download ZIP] i wypakuj w dogodnym miejscu
3. W programie Android Studio:
  Lewy górny róg: File -> Open...
  Zaznacz wypakowany projekt i kliknij ok
4. W celu poprawnego działania aplikacji będziesz musiał wykonać kilka kroków - zacznij od pobrania pliku login.db, naastępnie uruchom emulator np. poprzez uruchomienie aplikacji.
5. Na cienkim pasku po prawej stronie znajduje się zakładka Device File Menager - kliknij ją, ukażą Ci się foldery w telefonie.
6. Przejdź do data>data>com.example.baiimsqli>databases - kliknij prawym przyciskiem, Upload i wybierz pobrany plik login.db rozmiar pliku powinen zmienić się na 60KB
7. Przejdź do zakładki emulator i kliknij x obok nazwy w celu zresetowania urządzenia.
8. Uruchom aplikację ponownie, życzymy powodzenia w zadaniach!  

## Zadania

Hint: korzystamy z SQLite

Hint: zazwyczaj injection zaczynamy ze znakiem ```'``` i kończymy na ```--```

Hint: skróty **Ctrl+V** itp. nie działają z emulatorem androida ale wklejać tekst możemy tak jakbyśmy robili to na prawdziwym androidzie - klikamy i przytrzymujemy w polu tekstowym aż pojawią się nam opcje **Cut Copy Paste** itp.

Przydatne strony:
  > https://github.com/swisskyrepo/PayloadsAllTheThings/blob/master/SQL%20Injection/SQLite%20Injection.md#sqlite-comments
  
  > https://www.exploit-db.com/docs/english/41397-injecting-sqlite-database-based-applications.pdf
  
  > https://www.invicti.com/blog/web-security/sql-injection-cheat-sheet/
  
### Zad 1. Proste SQL Injection
  Spróbuj uzyskać dostęp do wyszukiwarki filmów (która normalnie dostępna jest po zalogowaniu/zarejestrowaniu) przy pomocy SQL Injection
  
  Przesłanie rozwiązania: prześlij użyte polecenie i napisz, gdzie zostało umieszczone || screenshot z aplikacji
  
 
### Zad 2. Union Attack
  Celem zadania jest pozyskanie hasła administratora aplikacji 
  
  *(Dla wygody hasła przechowywane w bazie nie są w żaden sposób hashowane)*
  
  Posiłkując się przydatnymi stronami pozyskaj nazwy kolumn, następnie tabel, a ostatecznie nazwy i hasła użytkowników
  
  Przesłanie rozwiązania: prześlij użyte polecenia i hasło administratora
  
### Zad 3. Input Sanitization
  Zmień kod w **DatabaseHelper.java** tak, żeby zapobiec SQL Injection.
  
  Przesłanie rozwiązania: prześlij poprawiony plik **DatabaseHelper.java** || przekopiuj jego kod w odpowiedzi || wpisz do odpowiedzi przykładowo: 
  ```linia kodu oryginalna``` -> ```linia kodu poprawiona```
  
