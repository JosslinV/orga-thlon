package rocher;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResizableImageIcon extends ImageIcon {
	
	public ResizableImageIcon(String URL) {
		super(URL);
		
	}

	public ImageIcon resize () {
		
		return new ImageIcon(this.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	}

}
