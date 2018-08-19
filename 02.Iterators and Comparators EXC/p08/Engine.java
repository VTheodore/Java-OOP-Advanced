package IteratorsAndComparatorsEXC.p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private ClinicManager cl;

    private BufferedReader reader;

    public Engine() {
        this.cl = new ClinicManager();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        int n = Integer.parseInt(this.reader.readLine());

        while (n-- > 0){
            String[] cmdArgs = this.reader.readLine().split("\\s+");

            String command = cmdArgs[0] ;

            switch (command){
                case "Create":
                    if (cmdArgs.length == 5){
                        try {
                            this.cl.createPet(cmdArgs[2], Integer.parseInt(cmdArgs[3]), cmdArgs[4]);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                    }else {
                        try {
                            this.cl.createClinic(cmdArgs[2], Integer.parseInt(cmdArgs[3]));
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(this.cl.add(cmdArgs[1], cmdArgs[2]));
                    break;
                case "Release":
                    System.out.println(this.cl.release(cmdArgs[1]));
                    break;
                case "HasEmptyRooms":
                    System.out.println(this.cl.hasEmptyRooms(cmdArgs[1]));
                    break;
                case "Print":
                    if (cmdArgs.length == 2){
                        this.cl.print(cmdArgs[1]);
                    }else{
                        this.cl.print(cmdArgs[1], Integer.parseInt(cmdArgs[2]));
                    }
                    break;
            }
        }
    }
}
