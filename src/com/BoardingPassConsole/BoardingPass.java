package BoardingPass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoardingPass {
    private BufferedImage boardingPass = new BufferedImage(708, 312, BufferedImage.TYPE_INT_ARGB);
    //private final File generatedFiles = new File("C:\\Users\\sydes\\Desktop\\BoardingPassGroup\\GenSparkProjects\\src\\com\\BoardingPass\\BoardingPassOutput");
    public String type;
    public String name;
    public String flightNum;
    public String from;
    public String destination;
    public String gate;
    public String seat;
    public  String gender;
    public  String email;
    public  String phone;
    public  String age;
    private Date date = new Date();
    public final Random ran = new Random();
    public BoardingPass(String type, String name, String from, String destination, String age, String email, String gender, String phone) throws IOException {
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.type = type;
        this.name = name;
        this.from = from;
        this.destination = destination;
        this.phone = phone;
    }
    public void generatePass() throws IOException {
        boardingPass = passType();
        flightNum = generateFlightNum();
        gate = generateGate();
        date = departureDate();
        Graphics2D g2d = boardingPass.createGraphics();

        g2d.setFont(new Font("san", Font.BOLD, 12));
        g2d.setPaint(Color.white);

        //Email
        g2d.drawString(email.toUpperCase(Locale.ROOT), 152, 362);

        //Phone Number
        g2d.drawString(phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"), 382, 362);

        g2d.setFont(new Font("san", Font.BOLD, 15));
        g2d.setPaint(Color.black);

        //Name
        g2d.drawString(name.toUpperCase(Locale.ROOT), 152, 145);

        //Gender
        g2d.drawString(gender.toUpperCase(Locale.ROOT), 295, 145);

        //Age
        g2d.drawString(age.toUpperCase(Locale.ROOT), 360, 145);

        //From
        g2d.drawString(from.toUpperCase(Locale.ROOT), 152, 205);

        //Destination
        g2d.drawString(destination.toUpperCase(Locale.ROOT), 152, 260);

        //Date
        g2d.drawString(new SimpleDateFormat("dd/MM/yyy").format(date).toUpperCase(Locale.ROOT), 382, 145);

        //Time
        g2d.drawString(new SimpleDateFormat("HH:mm:ss").format(date).toUpperCase(Locale.ROOT), 542, 145);

        //FlightNum
        g2d.drawString(flightNum.toUpperCase(Locale.ROOT), 382, 260);

        //Seat
        g2d.drawString(seat.toUpperCase(), 542, 205);

        //Gate
        g2d.drawString(gate.toUpperCase(Locale.ROOT), 382, 205);


        //SmallPrint
        g2d.setPaint(Color.DARK_GRAY);
        g2d.setFont(new Font("san", Font.BOLD, 10));

        //Name
        g2d.drawString(name.toUpperCase(Locale.ROOT), 730, 115);

        //From
        g2d.drawString(from.toUpperCase(Locale.ROOT), 730, 152);

        //Destination
        g2d.drawString(destination.toUpperCase(Locale.ROOT), 730, 190);

        //Date
        g2d.drawString(new SimpleDateFormat("dd/MM/yyy").format(date).toUpperCase(Locale.ROOT), 730, 230);

        //Time
        g2d.drawString(new SimpleDateFormat("HH:mm:ss").format(date).toUpperCase(Locale.ROOT), 837, 190);

        //FlightNum
        g2d.drawString(flightNum.toUpperCase(Locale.ROOT), 730, 304);

        //Seat
        g2d.drawString(seat.toUpperCase(), 837, 230);

        //Gate
        g2d.drawString(gate.toUpperCase(Locale.ROOT), 730, 268);

        g2d.dispose();

    }
    public void writeImage() throws IOException {
        File file = new File("C:\\Users\\sydes\\Desktop\\BoardingPassGroup\\GenSparkProjects\\src\\com\\BoardingPass\\BoardingPassOutput\\BoardingPass" + flightNum + "-" + seat + ".png");
        ImageIO.write(boardingPass, "png", file);
    }
    private BufferedImage passType() throws IOException {
        if(type.toUpperCase().equals("B")) {
            boardingPass = ImageIO.read(new File(("C:\\Users\\sydes\\Desktop\\BoardingPassGroup\\GenSparkProjects\\src\\com\\BoardingPass\\Assets\\BuisnessClass.jpg")));
        }
        else {
            boardingPass = ImageIO.read(new File(("C:\\Users\\sydes\\Desktop\\BoardingPassGroup\\GenSparkProjects\\src\\com\\BoardingPass\\Assets\\EconomyClass.jpg")));
        }

        return boardingPass;
    }
    private String generateFlightNum(){
        String aToZ = "abcdefghijklmnopqrstuvwxyz";
        int ranS = ran.nextInt(aToZ.length());
     int rans2 = ran.nextInt(aToZ.length());

     flightNum = (ran.nextInt(0,9)) + aToZ.substring(ranS, ranS+1)
             + (ran.nextInt(0,9)) + aToZ.substring(rans2, rans2+1);
     return  flightNum;
    }
//   private String  generateSeat() {
//
//       ArrayList<String> availableSeat = new ArrayList<>();
//
//       for (Seat s : Seat.values()) {
//           boolean b = (s.toString().endsWith(Integer.toString(1)) && s.toString().length() == 2) ||
//                   (s.toString().endsWith(Integer.toString(2)) && s.toString().length() == 2) ||
//                   (s.toString().endsWith(Integer.toString(3)) && s.toString().length() == 2) ||
//                   (s.toString().endsWith(Integer.toString(4)) && s.toString().length() == 2);
//
//           if (BoardingFrame.flightClass.equals("B")) {
//               if (b) {
//                   availableSeat.add(String.valueOf(s));
//               }
//           } else {
//               if (b) {
//                   continue;
//               } else
//                   availableSeat.add(String.valueOf(s));
//           }
//       }
//
//       for (String fileName : generatedFiles.list()) {
//           String substring = fileName.substring(fileName.lastIndexOf("-") + 1, fileName.lastIndexOf("."));
//           if (availableSeat.contains(substring)) {
//               availableSeat.remove(substring);
//           }
//       }
//
////       while (seat == null) {
////           System.out.println("Please choose an Available Seats or Enter 0 for random seat");
////           System.out.println(availableSeat);
////           String inputSeat = userInput.nextLine();
////           if (availableSeat.contains(inputSeat.toUpperCase())) {
////               seat = inputSeat;
////           } else if (inputSeat.equals("0")) {
////               seat = availableSeat.get(ran.nextInt(availableSeat.size()));
////           } else {
////               System.out.println("Seat is unavailable Please choose another");
////           }
////           seat = BoardingFrame.seat;
////       }
//           return seat;
//   }
        private String generateGate () {
            ArrayList<String> avalableGates = new ArrayList<>();
            for (Gates s : Gates.values()) {
                avalableGates.add(String.valueOf(s));
            }

            gate = avalableGates.get(ran.nextInt(avalableGates.size()));

            return gate;
        }
        private Date departureDate () {
            try {
                String days = BoardingFrame.days;
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, Integer.parseInt(days));
                date = cal.getTime();
                return date;
            } catch (Exception e) {
                date = new Date();
                return date;
            }
        }
        public void calculatePrice () {
            try {
                System.out.println("Estimated Arrival time for this ticket");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int hours = ran.nextInt(6, 24);
                calendar.add(Calendar.HOUR, hours);
                date = calendar.getTime();
                System.out.println(date);
            } catch (Exception e) {
                System.out.println("ERROR! Something went wrong");
            }
        }
}

