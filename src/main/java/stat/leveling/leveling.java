package stat.leveling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class leveling {
	//load from the another class
	public leveling save(int xp, int level, Player player) {
		   Properties p = new Properties();
		   p.setProperty("xp", String.valueOf(xp));
		   p.setProperty("level",String.valueOf(level));
		   FileOutputStream out;
		try {
			out = new FileOutputStream(".\\level\\"+player.getName()+"-level.properties");
			try {
				p.store(out,"Save Level, xp for Player "+player);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static String getlevel(Player player) {
		 Properties p = new Properties();
	        FileInputStream in;
			try {
				in = new FileInputStream(".\\level\\"+player+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return p.getProperty("level");
	}
	public static String getxp(Player player) {
		 Properties p = new Properties();
	        FileInputStream in;
			try {
				in = new FileInputStream(".\\level\\"+player+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return p.getProperty("xp");
	}
	public static leveling adden(int xp, int level, Entity killer) {
		   Properties p = new Properties();
		   FileInputStream in;
			try {
				in = new FileInputStream(killer+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int xps = (int) p.get("xp")+xp;
			int levels = (int) p.get("level")+level;
			if(xp >= 2500) {
				xps-=2500;
				levels++;
			}
			
		   p.setProperty("xp", String.valueOf(xps));
		   p.setProperty("level",String.valueOf(levels));
		   FileOutputStream out;
		try {
			out = new FileOutputStream(killer.getName()+"-level.properties");
			try {
				p.store(out,"Save Level, xp for Player "+killer);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static leveling addpl(int xp, int level, Player tr) {
		   Properties p = new Properties();
		   FileInputStream in;
			try {
				in = new FileInputStream(tr+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			int xps = (int) p.get("xp")+xp;
			int levels = (int) p.get("level")+level;
			if(level == 100) {
			if(xp >= 2500) {
			}
			} else if(xp >= 2500) {
				xps -= 2500;
				levels++;
			}
			
		   p.setProperty("xp", String.valueOf(xps));
		   p.setProperty("level",String.valueOf(levels));
		   FileOutputStream out;
		try {
			out = new FileOutputStream(tr.getName()+"-level.properties");
			try {
				p.store(out,"Save Level, xp for Player "+tr);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static String getxpen(Entity player) {
		 Properties p = new Properties();
	        FileInputStream in;
			try {
				in = new FileInputStream(".\\level\\"+player+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return p.getProperty("xp");
	}
	public static String getlevelen(Entity player) {
		 Properties p = new Properties();
	        FileInputStream in;
			try {
				in = new FileInputStream(".\\level\\"+player+"-level.properties");
				try {
					p.load(in);
					 in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return p.getProperty("level");
	}
	
	
	
	
}
