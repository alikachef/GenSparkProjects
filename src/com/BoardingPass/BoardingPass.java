package BoardingPass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class BoardingPass {
    private final String aToZ = "abcdefghijklmnopqrstuvwxyz";
    private BufferedImage boardingPass = new BufferedImage(708, 312, BufferedImage.TYPE_INT_ARGB);
    private File file;
    private String type;
    private String name;
    private String flightNum;
    private String from;
    private String destination;
    private Date date = new Date();
    private Gates gate;
    private Seat seat;

    public BoardingPass(String type, String name, String from, String destination) {
        this.type = type;
        this.name = name;
        this.flightNum = flightNum;
        this.from = from;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void generatePass() throws IOException {
        boardingPass = passType();
        flightNum = generateFlightNum();
        Graphics2D g2d = boardingPass.createGraphics();

        g2d.setPaint(Color.black);
        g2d.setFont(new Font("san", Font.BOLD, 15));

        //Name
        g2d.drawString(name.toUpperCase(Locale.ROOT), 152, 145);

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

        g2d.dispose();

    }


    public void writeImage() throws IOException {
        file = new File("src/com/BoardingPass/BoardingPassOutput/BoardingPass" + flightNum +  ".png");
        ImageIO.write(boardingPass, "png", file);
    }
    private BufferedImage passType() throws IOException {
        if(type.toUpperCase().equals("B")) {
            boardingPass = ImageIO.read(new File(("src/com/BoardingPass/Assets/BuisnessClass.jpg")));
        }
        else {
            boardingPass = ImageIO.read(new File(("src/com/BoardingPass/Assets/EconomyClass.jpg")));
        }

        return boardingPass;
    }
    private String generateFlightNum(){

     Random ran = new Random();
     int ranS = ran.nextInt(aToZ.length());
     int rans2 = ran.nextInt(aToZ.length());

     flightNum = (ran.nextInt(0,9)) + aToZ.substring(ranS, ranS+1)
             + (ran.nextInt(0,9)) + aToZ.substring(rans2, rans2+1);
     return  flightNum;
    }
    public ArrayList<String> generateSeat(){
        ArrayList<String> availableSeat = new ArrayList<>();
        for (Seat s: Seat.values() ){
            if(type.toUpperCase().equals("B")){
                if(s.toString().endsWith(Integer.toString(1)) ||
                        s.toString().endsWith(Integer.toString(2)) ||
                        s.toString().endsWith(Integer.toString(3)) ||
                        s.toString().endsWith(Integer.toString(4)))
                availableSeat.add(String.valueOf(s));
            }
            availableSeat.add(String.valueOf(s));
        }
        System.out.println(availableSeat);
        return availableSeat;
    }

}
