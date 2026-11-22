# Java Vehicle Rental System

A command-line Java application for a small vehicle rental agency. The program separates administrator and client actions, models cars and motorcycles, and records rental dates and costs. It is built around Java classes and local CSV files rather than a web interface or database.

## Application flow

When launched, the program loads the saved data and displays the main menu:

```text
1. Espace Administrateur
2. Espace Client
0. Quitter
```

### Administrator area

The administrator menu provides the following operations:

```text
1. Ajouter Vehicule
2. Supprimer Vehicule
3. Modifier prix vehicule
4. Afficher Parc
5. Ajouter Client
6. Afficher Clients
7. Louer un vehicule
8. Afficher Locations actives
9. Restituer un vehicule
10. Sauvegarder données
11. Charger données
0. Retour Menu principal
```

Adding a vehicle prompts for its type (`v` for a car or `m` for a motorcycle), make, model, and daily price. Cars also ask for a door count; motorcycles ask for engine capacity. The application generates a vehicle reference when each vehicle is created.

### Client area

A client enters their client ID to access this menu:

```text
1. Consulter Vehicule disponible
2. Louer un vehicule
3. Restituer un vehicule
4. Sauvegarder mes données
0. Retour Menu principal
```

The client can browse available vehicles, rent one by reference, and return a vehicle linked to their client account. Rental dates are entered in `YYYY-MM-DD` format. The total cost uses the daily price and counts both the start and end dates. The program checks that the client and vehicle exist, the vehicle is available, and the start date is not after the end date.

Client IDs are generated with a `C` prefix; car and motorcycle references use `V` and `M` prefixes respectively.

## Code layout

```text
src/Projet_LocationVehicule/
├── main/
│   ├── AppLocation.java       # Application entry point and main menu
│   ├── MenuAdmin.java         # Administrator CLI options
│   └── MenuClient.java        # Client CLI options
├── model/
│   ├── Vehicule.java          # Abstract base vehicle class
│   ├── Voiture.java           # Car model
│   ├── Moto.java              # Motorcycle model
│   ├── Client.java            # Client details and generated ID
│   ├── Location.java          # Rental dates, participants, and total cost
│   ├── Administrateur.java    # Administrator credential model
│   └── LocationException.java # Rental and management exception
├── service/
│   └── AgenceLocation.java    # Fleet, client, and rental operations
└── utile/
    └── FichierUtil.java       # CSV save/load methods
```

`Vehicule` defines the shared vehicle information: reference, make, model, daily price, and availability. `Voiture` and `Moto` extend it with their specific attributes. `AgenceLocation` manages the fleet, clients, and active rentals, while `FichierUtil` handles file input and output.

## CSV data

The program uses three files in the current working directory. They are loaded at startup and saved when the user exits; the administrator menu also has separate save and load options.

| File | Stored records |
| --- | --- |
| `parc.csv` | Vehicle type, make, model, daily price, availability, and car door count or motorcycle engine capacity |
| `clients.csv` | Client first name, last name, and ID |
| `locations.csv` | Client ID, vehicle reference, start date, end date, and rental total |

The files are plain CSV with no header row.

## Requirements and execution

- Java JDK 17 or newer
- No external libraries

Compile from the repository root:

```bash
javac -encoding UTF-8 -d out src/Projet_LocationVehicule/model/*.java src/Projet_LocationVehicule/utile/*.java src/Projet_LocationVehicule/service/*.java src/Projet_LocationVehicule/main/*.java
```

Run the command-line application:

```bash
java -cp out Projet_LocationVehicule.main.AppLocation
```

## Java concepts demonstrated

- Object-oriented design, encapsulation, inheritance, and polymorphism
- Abstract classes and overridden methods
- Collections for keeping track of vehicles, clients, and rentals
- `LocalDate` and date-based rental calculations
- A custom checked exception for application errors
- Text-file persistence using Java readers and writers

## Other Java exercises in the repository

The repository also contains separate Java practice work on language fundamentals, user input, arrays, strings, methods, dates and times, enums, exceptions, collections, maps, generics, and object-oriented programming. Additional exercises cover streams and file handling, threads and timers, a console alarm clock with audio, introductory Swing interfaces, and university topics such as banking accounts, a slot machine, a library, and inventory management.

---

Developed during the 2025–2026 academic year as part of Java coursework at the Faculty of Sciences of Sfax.
