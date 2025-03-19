# Sistem de Autentificare

Acest proiect implementează un sistem de autentificare simplu, care prelucrează datele introduse pentru nume, parolă, întrebări de securitate și răspunsuri. Utilizând diferite metode, programul asigură validarea datelor, stocarea acestora și gestionarea erorilor de autentificare și logare.

### Funcționalități Cheie:

- **Prelucrarea Intrărilor**:  
  Din vectorul `args[i]`, programul primește diverse stringuri pentru introducerea numelui, parolei, întrebărilor și răspunsurilor.  
  Prin utilizarea metodelor `NumeleMeuNumeleMeu`, `CaUnDiamantVaStraluciMereu` și `IntrebariText`, am separat aceste informații din stringuri.  
  Ulterior, cu ajutorul comenzii `replace`, am delimitat elementele pentru a le putea utiliza în continuare.

- **Stocarea și Validarea Datelor**:  
  Am creat și citit din fișierul `usernamepassword.txt` pentru a verifica dacă un nume, o parolă sau o întrebare există deja.  
  Aceste date sunt stocate în fișiere separate pentru a putea fi accesate ulterior.

- **Gestionarea Erorilor**:  
  - **Eroare de Autentificare**: Erorile de autentificare sunt gestionate prin verificarea lungimii stringului; dacă este mai mică sau egală cu 2, înseamnă că nu au fost furnizate suficiente date.  
  - **Eroare de Logare**: În cazul în care utilizatorul încearcă să se logheze, programul compară numele de utilizator și parola cu datele deja stocate pentru a valida autentificarea.

- **Curățarea Datelor**:  
  La final, am utilizat funcția de cleanup pentru a înlocui conținutul fișierului cu un string gol, astfel eliminând datele stocate.