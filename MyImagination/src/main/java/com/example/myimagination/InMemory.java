package com.example.myimagination;

import BandMath.Figures.Camera;
import BandMath.Figures.Point;
import BandMath.Figures.Triangle;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;

public class InMemory extends Frame {

    public static ImageObserver imageObserver;
    private int w = 500, h = 500;
    private Triangle triangle = new Triangle(0,0,500,500,500,20);

    public void setPix(int[] pix) {
        this.pix = pix;
    }

    public int[] pix = new int[w * h];

    private Image img;

    InMemory(String s) {

    super(s);


    int i = 0;
        Camera cam = new Camera(new Point(0,0,0),1024,768,1000,90,0,90);
        Triangle triangle1 = new Triangle(0,0,500,500,500,20,0,0,0);
        cam.makePicture(triangle1);

    for (int Y = 0; Y < h; Y++){
        for (int x = 0; x < w; x++){
            pix[i++] = cam.getPicture()[x][Y];
//            if (triangle.isInside(x,Y)) {
//                Color color = Color.BLACK;
//                pix[i++] = color.getRGB();
//
//               //System.out.print("*");
//            }
//            else {
//                Color color = Color.GRAY;
//                pix[i++] = color.getRGB();
//                //System.out.print("O");
//            }

//                    (255 << 24)|(red << 16)|(green << 8)| 128;
        }
        System.out.println();
    }

    setSize(1400, 1400);

    setVisible(true);

}

    public void paint(Graphics gr){

        if (img == null)

            img = createImage(new MemoryImageSource (h,w,pix,0,w));
        gr.drawImage(img, 50, 50, this);
        imageObserver = this;

    }

    public static void main(String[] args) throws InterruptedException {

        Frame f= new InMemory(" Изображение в памяти");
        Thread.sleep(1000);
        InMemory inMemory = (InMemory)f;
        inMemory.pix = new int[500*500];
        Graphics g = f.getGraphics();
        g.drawImage(inMemory.img,50,50,null);
       inMemory.paint(g);


        f.addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent ev){

                System.exit (0);

            }

        });

    }

}