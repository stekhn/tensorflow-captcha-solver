import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nl.captcha.Captcha;
import nl.captcha.Captcha.Builder;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.gimpy.FishEyeGimpyRenderer;
import nl.captcha.noise.StraightLineNoiseProducer;
import nl.captcha.text.producer.ChineseTextProducer;
import nl.captcha.text.producer.DefaultTextProducer;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub // Required! Always! lol
		img2ds("../solver/data/train_data/",50000);
		img2ds("../solver/data/valid_data/",20000);
		img2ds("../solver/data/test_data/",1000);

	}

	public static void img2ds(String dir, int N) throws IOException
	{
		Color c=new Color(1f,0f,0f,.0f);
		for(int i=1;i<=N;i++)
		{
			if(i%100==0)System.out.println(i+","+N);
			Captcha cap = new Captcha.Builder(150, 50)
			     .addText()
			     .gimp(new FishEyeGimpyRenderer(c, c))
			     .build();
			img2file(dir+"/"+cap.getAnswer()+".png",cap.getImage());
		}
	}

	public static void img2disp(BufferedImage img)
	{

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		frame.pack();
		frame.setVisible(true);
	}

	public static void img2file(String fileName, BufferedImage img) throws IOException
	{
		ImageIO.write(img, "png", new File(fileName));

	}

}
