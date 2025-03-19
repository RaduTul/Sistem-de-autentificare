package com.example.project;

import java.io.*;
import java.util.Scanner;

public class Tema1 {
	public static String NumeleMeuNumeleMeu(String u) {
		String Username = u.replace("'", "");
		String Usernamenou = Username.replaceFirst("-u ", "");
		return Usernamenou;
	}

	public static String CaUnDiamantVaStraluciMereu(String p) {
		String Parola = p.replace("'", "");
		String Parolanoua = Parola.replaceFirst("-p ", "");
		return Parolanoua;
	}

	public static String IntrebariText(String i) {
		String Intrebare = i.replace("'", "");
		String IntrebareNoua = Intrebare.replaceFirst("-text ", "");
		return IntrebareNoua;
	}

	String mesajeroare = "{ 'status' : 'error', 'message' : 'User already exists'})";

	public static void main(final String[] args) {
		String username = null;
		String parola = null;
		String usernamequestion = null;
		String parolaquestion = null;
		if (args == null) {
			System.out.print("Hello world!");
		} else {
			for (int i = 0; i < args.length; i++) {
				//System.out.println(args[i] + "i la for =" + i);
				if (args[i].compareTo("-create-user") == 0) {
					if (args.length == 1) {
						User.ProvideUser();
						return;
					}
					if (args.length == 2) {
						User.ProvidePassword();
						return;
					}
					if (args[i + 1].charAt(1) == 'u') {
						username = NumeleMeuNumeleMeu(args[i + 1]);
					}
					if (args[i + 2].charAt(1) == 'p') {
						parola = CaUnDiamantVaStraluciMereu(args[i + 2]);
						//System.out.println(parola);
						try {
							File myObj = new File("userpassword.txt");
							Scanner myReader = new Scanner(myObj);
							while (myReader.hasNextLine()) {
								String data = myReader.nextLine();
								String datanoua = data.replace(parola, ""); //username
								String datazece = datanoua.replace(",", "");
								if (datazece.compareTo(username) == 0) {
									User.UserExists();
									return;
								}
							}
							//System.out.println("cf frumoasa");
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						try (FileWriter fw = new FileWriter("userpassword.txt", true);
							 BufferedWriter bw = new BufferedWriter(fw);
							 PrintWriter out = new PrintWriter(bw)) {

							out.println(username + "," + parola);
							//more code


						} catch (IOException e) {
							throw new RuntimeException(e);
						}
						//System.out.println("{'status':'ok','message':'User created successfully'}");
						User.UserSucces();
					}
				}
				if (args[i].compareTo("-create-question") == 0) {
					if (args.length <= 2) {
						Question.Authentific ();
						return;
					}
					if (args[i + 1].charAt(1) == 'u') {
						usernamequestion = NumeleMeuNumeleMeu(args[i + 1]);
					}
					if (args[i + 2].charAt(1) == 'p') {
						parolaquestion = CaUnDiamantVaStraluciMereu(args[i + 1]);
					}
					if (args.length == 3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parolaquestion, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(usernamequestion) == 0) {
								Question.LoginFailed();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}// verificam useru si parola sa fie matchy matchy
					String intrebare = args[i + 3];
					CharSequence text = "-text";
					boolean bool = intrebare.contains(text);
					if (bool == true) {
						intrebare = IntrebariText(args[i + 3]);
						try {
							File myObj = new File("intrebari.txt");
							Scanner myReader = new Scanner(myObj);
							while (myReader.hasNextLine()) {
								String data = myReader.nextLine();
								String datanoua = intrebare;
								if (datanoua.compareTo(intrebare) == 0) {
									System.out.println("{ 'status' : 'error', 'message' : 'Question already exists'}");
									return;
								}
							}
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						try (FileWriter fw = new FileWriter("intrebari.txt", true);
							 BufferedWriter bw = new BufferedWriter(fw);
							 PrintWriter out = new PrintWriter(bw)) {
							out.println(intrebare);

							//more code
							//out.println("more text");
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					Question.Succes();
				}

				if (args[i].compareTo("-get-question-id-by-text") == 0) {
					if (args.length < 2) {
						Question.Authentific ();
						return;
					}
					if (args.length <= 3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}

				}

				if (args[i].compareTo("-get-all-questions") == 0) {
					if (args.length <= 2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3 ) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}


				}

				if (args[i].compareTo("-create-quizz") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length ==3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}

				if (args[i].compareTo("-create-quizz-by-name") == 0) {
					if (args.length <= 2) {
						Question.Authentific ();
						return;
					}
					if (args.length ==3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}

				if (args[i].compareTo("-get-all-quizzes") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}

				}

				if (args[i].compareTo("-get-quizz-details-by-id") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}

				if (args[i].compareTo("-submit-quizz") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) { //aici e ceva cu id
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								Question.LoginFailed();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}

				if (args[i].compareTo("-get-all-quizzes") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) {
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}
				//aici poate mai bag altele
				//
				//
				//

				if (args[i].compareTo("-delete-quizz-by-id") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) { //aici la fel cu id, o sa compari numele, parola nu numarul de length
						Question.LoginFailed();
						return;
					}
					try {
						File myObj = new File("userpassword.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String datanoua = data.replace(parola, ""); //username
							String datazece = datanoua.replace(",", "");
							if (datazece.compareTo(username) == 0) {
								User.UserExists();
								return;
							}
						}
						//System.out.println("cf frumoasa");
						myReader.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}

				}

				if (args[i].compareTo("-get-my-solutions") == 0) {
					if (args.length <=2) {
						Question.Authentific ();
						return;
					}
					if (args.length == 3) {
						Question.LoginFailed();
						return;
					}
				}
				if (args[i] == "-cleanup-all") {
					try {
						PrintWriter writer = new PrintWriter("userpassword.txt");
						writer.print("");
						writer.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
					try {
						PrintWriter writer = new PrintWriter("intrebari.txt");
						writer.print("");
						writer.close();
					} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}

			}

		/*if (args[0] == "-cleanup-all") {
			try {
				PrintWriter writer = new PrintWriter("userpassword.txt");
				writer.print("");
				writer.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}*/
		}
	}
}