package com.gamearcade.developerpublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperPublisherImpl implements IDeveloperPublisher {
protected List<GameModel> gameList;
	
	public DeveloperPublisherImpl() {
		super();
		
		gameList = new ArrayList<GameModel>();
		
		GameModel g1 = new GameModel("G0001","Minecraft","Mojang","Adventure","Easy","World Based");
		GameModel g2 = new GameModel("G0002","Terraria","ABC Dev","Adventure","Easy","World Based");
		GameModel g3 = new GameModel("G0003","Call of Duty","Activision","Arcade","Medium","Arcade based shooter");
		GameModel g4 = new GameModel("G0004","Spiderman","Insomniac","Sci-Fi","Medium","Sci-Fi based action");
		GameModel g5 = new GameModel("G0005","Batman","Rock Steady","Action","Medium","Action based open world");
		GameModel g6 = new GameModel("G0006","FIFA","EA","Sports","Medium","Sports based on football");
		GameModel g7 = new GameModel("G0007","GTA 6","RockStar","Adventure","Easy","Open world based game");
		GameModel g8 = new GameModel("G0008","Forza Horizon","EA","Sports","Easy","Racing game");
		GameModel g9 = new GameModel("G0009","Elden Ring","EA","Adventure","Hard","Adventure based open world");

		gameList.add(g1);
		gameList.add(g2);
		gameList.add(g3);
		gameList.add(g4);
		gameList.add(g5);
		gameList.add(g6);
		gameList.add(g7);
		gameList.add(g8);
		gameList.add(g9);

	}

	@Override
	public void addNewGame() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String id, name, dev, genre, diff, otherDet = "";

		while (true) {
			GameModel newGame = new GameModel();
			
			System.out.println();
			
			System.out.println("***************** Add New Game *****************");
			while (true) {

				System.out.print("Enter game id: ");
				id = scan.next();

				if (id == "") {
					System.out.println("Id cannot be empty");

				} else if (id.length() < 5) {
					System.out.println("Id must have more than 5 characters");
				} else {

					newGame.setGameId(id);
					break;
				}
			}

			while (true) {
				System.out.print("Enter game name: ");
				name = scan.next();

				if (name == "") {
					
					System.out.println("Game Name cannot be empty");
					
				}
				else {

					newGame.setGameName(name);
					break;

				}
			}

			while (true) {
				System.out.print("Enter game developer: ");
				dev = scan.next();
				if (dev == "") {
					
					System.out.println("Developer cannot be empty ");
					
				} 
				else {
					
					newGame.setGameDev(dev);
					break;

				}
			}

			while (true) {
				System.out.print("Enter genre: ");
				genre = scan.next();
				if (genre == "") {
					
					System.out.println("Genre cannot be empty");
					
				} else {
					
					newGame.setGenre(genre);
					break;
					
				}
			}

			while (true) {
				System.out.print("Enter Difficulty: ");
				diff = scan.next();
				if (diff == "") {
					
					System.out.println("Difficulty cannot be empty");
					
				} else {
					
					newGame.setDifficulty(diff);
					break;
					
				}
			}

			while (true) {
				System.out.print("Enter game details: ");
				otherDet = scan.next();
				if (otherDet != "") {
					
					newGame.setOtherDetails(otherDet);
					break;
					
				} else {
					
					System.out.println("Game Details cannot be empty");
					
				}
			}


			gameList.add(newGame);

			System.out.println();
			System.out.println("Enter number 1 to exit: ");
			System.out.println("Enter any other number to add more games: ");
			int option = scan.nextInt();

			if (option == 1) {
				break;
			}

		}
	}

	@Override
	public void viewAllGames() {
		
		if (gameList.isEmpty()) {
			System.out.println("No Games Added...");
		}

		System.out.println();
		System.out.println("***************** View All Games *****************");
		for (GameModel gm : gameList) {

			System.out.println(gm.toString());
			System.out.println();
		}
		
	}

	@Override
	public void searchGameById() {
		
		String id;
		boolean done = false;
		
		System.out.println();
		System.out.println("***************** View Game *****************");
		System.out.print("Enter Game Id to search: ");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		id = scan.next();

		for (GameModel gm : gameList) {

			if (gm.getGameId().equalsIgnoreCase(id)) {
				System.out.println("Course Found");
				System.out.println(gm.toString());
				done = true;
				break;
			}

		}

		if (!done) {
			System.out.println();
			System.out.println("Game Not Found...");
		}
		
	}

	@Override
	public void deleteGameById() {
		
		String id;
		boolean done = false;
		
		System.out.println();
		System.out.println("***************** Delete Game *****************");
		System.out.print("Enter Game Id to delete: ");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		id = scan.next();

		for (int x = 0; x < gameList.size(); x++) {

			if (gameList.get(x).getGameId().equalsIgnoreCase(id)) {
				System.out.println("Game will be Deleted!");
				gameList.remove(x);
				System.out.println("Game is Deleted!");
				done = true;
				break;

			}

		}
		if (!done) {
			System.out.println();
			System.out.println("Game Not Found...");
		}
		
	}
 
	@Override
	public void updateGame() {
		
		String id, name, dev, genre, diff, otherDet = "";
		int opt;
		boolean done = false;
		
		System.out.println();
		System.out.println("***************** Update Game *****************");
		
		System.out.print("Enter Game Id to update: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		id = scan.next();

		for (int x = 0; x < gameList.size(); x++) {

			if (gameList.get(x).getGameId().equalsIgnoreCase(id)) {

				while (true) {
					System.out.println();
					System.out.println("Select an option to update: ");
					System.out.println("1 - Update Game Name:\n" + "2 - Update Developer:\n" + "3 - Update Genre:\n"
							+ "4 - Update Difficulty\n" + "5 -  Update details\n" + "6 - Exit \n");

					opt = scan.nextInt();

					if (opt == 1) {

						while (true) {
							System.out.print("Enter game name: ");
							name = scan.next();

							if (name == "") {
								System.out.println("Name can not be empty");

							}
							else {

								gameList.get(x).setGameName(name);
								break;

							}
						}

					}

					else if (opt == 2) {

						while (true) {
							System.out.print("Enter game developer: ");
							dev = scan.next();
							if (dev == "") {
								System.out.println("Developer can not be empty ");
							}

							else {
								gameList.get(x).setGameDev(dev);
								break;
							}
						}

					}

					else if (opt == 3) {

						while (true) {
							System.out.print("Enter game genre: ");
							genre = scan.next();
							if (genre == "") {
								System.out.println("Genre can not be empty");
							}else {
								gameList.get(x).setGenre(genre);
								break;
							}
						}

					}

					else if (opt == 4) {

						while (true) {
							System.out.print("Enter game difficulty: ");
							diff = scan.next();
							if (diff != "") {
								gameList.get(x).setDifficulty(diff);
								break;
							} else {
								System.out.println("Difficulty can not be empty");
							}
						}
					}

					else if (opt == 5) {
						while (true) {
							System.out.print("Enter game details: ");
							otherDet = scan.next();
							if (otherDet != "") {
								gameList.get(x).setOtherDetails(otherDet);
								break;
							} else {
								System.out.println("Details can not be empty");

							}
						}
					}

					else if (opt == 6) {
						break;
					} else {
						System.out.print("Wrong option");
					}
				}

				done = true;

			}

		}
		if (!done) {
			System.out.println();
			System.out.println("Game Not Found...");
		}
		
	}

	@Override
	public void selectGameOption(String consumer) {
		
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);

		boolean run = true;
		do {
			if(consumer.equals("admin")) {
				System.out.println("Select your choice(1-3) :");
				System.out.println("1 - View all games");
				System.out.println("2 - Search game by Id");
				System.out.println("3 - Exit");

				int response = scn.nextInt();
				switch (response) {

					case 1:
						this.viewAllGames();
						break;
					case 2:
						this.searchGameById();
						break;
					case 3:
						run = false;
						break;
					default:
						System.out.print("Wrong option");
				}
			}
			else {
				// options for developer
				System.out.println("Select your choice(1-6) :");
				System.out.println("1 - Add a game");
				System.out.println("2 - View all games");
				System.out.println("3 - Search game by Id");
				System.out.println("4 - Update game ");
				System.out.println("5 - Delete game by Id");
				System.out.println("6 - Exit");

				int response = scn.nextInt();
				switch (response) {

					case 1:
						this.addNewGame();
						break;
					case 2:
						this.viewAllGames();
						break;
					case 3:
						this.searchGameById();
						break;
					case 4:
						this.updateGame();
						break;
					case 5:
						this.deleteGameById();
						break;
					case 6:
						run = false;
						break;
					default:
						System.out.print("Wrong option");
				}
			}
			
		} while (run == true);
	}
}
