package test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.images.Resolutions;
import org.graphstream.ui.geom.Point2;
import org.graphstream.ui.geom.Point3;
import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.layout.Layouts;
import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.swing_viewer.util.DefaultMouseManager;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.Viewer.CloseFramePolicy;
import org.graphstream.ui.view.camera.Camera;
import org.graphstream.ui.view.util.InteractiveElement;
import org.graphstream.ui.view.util.MouseManager;





public class project {

	protected static OnMyWayabc omw;
	private static OnMyWay omw4;
	private static OnMyWay2 omw5;
	private static DFS g;
	private static boolean freeze = true;

	private static JButton freezeButton1;
	private static JButton unfreezeButton1;

	static SingleGraph graph;
	private static String path = "";
	private static String[] v;
	static int[][] allIntArr;
	private static String[] arrOfStr;
	static int max = 0; // file index of the last vertex
	private static int i1, i2, i3 = 0, x = 0, y = 0, a = 0, y1 = 0;
	private static Integer[] c;
	static int size;
	private static JFrame welcomeFrame;
	static JFrame frame = new JFrame();
	private static JPanel buttonJPanel;
	protected static SwingViewer viewer;
	static ViewPanel view;
	private static ViewPanel view4;
	private static ViewPanel view5;
	private static ArrayList<Integer> vertex = new ArrayList<Integer>();
	private static LinkedList<Integer> aIntegers = new LinkedList<Integer>();
	private static ArrayList<String> hasNext=new ArrayList<>();
	private static HashMap<String,String[]> adjEdge=new HashMap<>();
	private static int preX = -1;
	private static int preY = -1;
	private static Camera camera;
	//    private static boolean freezeGraph = false;
	static boolean check=true; //D

	public static void main(String args[]) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					welcome();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		///welcome: hiện thị ra tên các thành viên trong nhóm và chọn file txt để chạy đồ thị
	}

	public static void welcome() throws IOException {
		welcomeFrame = new JFrame();
		BufferedImage myPicture = ImageIO.read(new File("project.jpg")); // ảnh logo đại học bách khoa
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));

		JPanel nameMember = new JPanel(); // nameMember panel chứa các label tên và mssv của các member
		JPanel dirPanel = new JPanel(); // dirPanel chứa button directory, finish và điền đường path của file txt
		nameMember.add(picLabel);
		JLabel[] mb = new JLabel[7];
		JLabel[] mssv = new JLabel[7];
		mb[1] = new JLabel("Hồ Anh");
		mssv[1] = new JLabel("20190037");
		mb[2] = new JLabel("Tạ Hữu Bình");
		mssv[2] = new JLabel("20190094");
		mb[3] = new JLabel("Nguyễn Hải Dương");
		mssv[3] = new JLabel("20190044");
		mb[4] = new JLabel("Trịnh Tùng Dương");
		mssv[4] = new JLabel("20190045");
		mb[5] = new JLabel("Trần Trọng Hiệp");
		mssv[5] = new JLabel("20190051");
		mb[6] = new JLabel("Lê Huy Hoàng");
		mssv[6] = new JLabel("20190053");
		nameMember.setLayout(new GridLayout(6, 2)); // tạo lớp layout 6 hàng 2 cột (kiểu dạng bảng 6x2)
		// các label được add vào sẽ theo thứ tự add vào các cột rồi đến các hàng, cái nào đc add trước thì thêm vào trước

		for(int i = 1; i <= 6; ++i) {
			mb[i].setFont(new Font("Helvetica", Font.PLAIN, 20)); // kiểu chữ Helvetica, cỡ chữ 20
			mssv[i].setFont(new Font("Helvetica", Font.PLAIN, 20));
			nameMember.add(mb[i]);    // mb[1] add vào trước sẽ ở ô (1,1), sau đó add mssv[1] sẽ ở ô (1,2), tiếp đó add mb[2] sẽ ở ô (2,1) và cứ như thế ta sẽ có được cái in mong muốn ra frame.....
			nameMember.add(mssv[i]);
		}


		JLabel dirLabel = new JLabel("Enter path ");
		JTextField dirText = new JTextField(50); // độ dài của phần được nhập là 50 ký tự
		JButton finishButton = new JButton("Ok"); // hoàn tất việc điền đường path và xử lý file txt đó
		JButton directoryButton = new JButton("Directory"); // chọn file txt thỏa mãn trong máy

//
//		BufferedImage finishBf = ImageIO.read(new File("label_button\\enter.png"));
//		Image finishdImg = finishBf.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//		ImageIcon finishImg = new ImageIcon(finishdImg);
//		finishButton.setIcon(finishImg);
//		finishButton.setBounds(10, 10, 208, 29);
//		finishButton.setBackground(Color.CYAN);
//
//		BufferedImage directoryBf = ImageIO.read(new File("label_button\\directory.jpg"));
//		Image directorydImg = directoryBf.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//		ImageIcon directoryImg = new ImageIcon(directorydImg);
//		directoryButton.setIcon(directoryImg);


		dirPanel.add(dirLabel);
		dirPanel.add(dirText);
		dirPanel.add(finishButton);
		dirPanel.add(directoryButton);
		String curentDir = System.getProperty("user.dir");
		JFileChooser fileDialog = new JFileChooser(curentDir + "\\DataGraph"); //xử lý việc chọn directory

		directoryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnval = fileDialog.showOpenDialog(welcomeFrame);
				if(returnval == JFileChooser.APPROVE_OPTION) {
					File file = fileDialog.getSelectedFile();
					String p = file.getName();
					if(!p.endsWith("txt")) { // nếu không là file txt lập tức thông báo lỗi
						JOptionPane.showMessageDialog(null, "File error", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else {
						path = file.getPath();
						try {
							prepare();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(graph.getEdgeCount() == 0) { // nếu file txt đó không phải file chứ dữ liệu đồ thị lập tức thông báo lỗi
							JOptionPane.showMessageDialog(null, "File error", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else {
							welcomeFrame.setVisible(false);
							view.setMouseManager(manager1);
							frame.setVisible(true);
							try {
								console();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				path =  dirText.getText();

				try {
					prepare();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(graph.getEdgeCount() == 0) {
					JOptionPane.showMessageDialog(null, "File error", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					welcomeFrame.setVisible(false);
					frame.setVisible(true);
					try {
						console();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		welcomeFrame.setTitle("Project Java");
		welcomeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		welcomeFrame.getContentPane().add(picLabel, BorderLayout.WEST);
		welcomeFrame.getContentPane().add(nameMember, BorderLayout.CENTER);
		welcomeFrame.getContentPane().add(dirPanel, BorderLayout.SOUTH);
		welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		welcomeFrame.setVisible(true);
	}

	/// console được gọi khi chọn xong file txt và xử lý xong phần prepare()
	public static void console() throws IOException {

		JButton showButton = new JButton("Bài 1"); // xử lý bài 1
		JButton AllPAthButton = new JButton("Bài 2"); // xử lý bài 2
		JButton AllPAthButton2 = new JButton("Bài 2#"); // xử lý bài 2z
		JButton QuestionsPathButton = new JButton("Bài 3");  // xử lý bài 3
		JButton bai4 = new JButton("Bài 4*");
		JButton bai5 = new JButton("Bài 5*");
		JButton WeightGraph = new JButton("Bài 6"); // xử lý bài 6
//		JButton Auto = new JButton("Bài 7"); //D
		JButton freezeButton = new JButton("Freeze");
		JButton unfreezeButton = new JButton("Unfreeze");
		JButton homeButton = new JButton(); // quay trở về welcomeframe
		JRadioButton radioButton=new JRadioButton("Stop autoLayout");

		BufferedImage homeBf = ImageIO.read(new File("label_button\\home.png"));
		Image homedImg = homeBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon homeImg = new ImageIcon(homedImg);
		homeButton.setIcon(homeImg);
		homeButton.setBounds(10, 10, 208, 29);
		homeButton.setBackground(Color.CYAN);

		freezeButton.setBackground(Color.BLUE);
		unfreezeButton.setBackground(Color.LIGHT_GRAY);
//        JButton homeButton = new JButton("Home"); // quay trở về welcomeframe

		freezeButton1 = new JButton("Freeze");
		unfreezeButton1 = new JButton("Unfreeze");

		freezeButton1.setBackground(Color.BLUE);
		unfreezeButton1.setBackground(Color.LIGHT_GRAY);

		JMenuBar menuBar = new JMenuBar();
		frame.add(menuBar, BorderLayout.NORTH);
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});
		buttonJPanel = new JPanel();
		buttonJPanel.add(homeButton);
		buttonJPanel.add(showButton);
		buttonJPanel.add(AllPAthButton);
		buttonJPanel.add(AllPAthButton2);
		buttonJPanel.add(QuestionsPathButton);
		buttonJPanel.add(bai4);
		buttonJPanel.add(bai5);
		buttonJPanel.add(WeightGraph);

//        buttonJPanel.add(radioButton);
//        if (freeze) {
//        	buttonJPanel.add(freezeButton1);
//        	buttonJPanel.remove(unfreezeButton1);
//        }
//        else {
//        	buttonJPanel.add(unfreezeButton1);
//        	buttonJPanel.remove(freezeButton1);
//        }
//		buttonJPanel.add(Auto); //D
		buttonJPanel.setBackground(Color.orange);

//        setLabel(frame);


		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame = new JFrame();
				max = 0;
				welcomeFrame.setVisible(true);
			}
		});
		showButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					frame.dispose();
					frame = new JFrame();
					prepare();
					console();
					frame.setVisible(true);
//					g.graphString("Bai1"); // thực hiện bài 1
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		AllPAthButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				omw.runDFS(1, max, "Bai2"); // in tất cả các đường đi từ đỉnh đầu đên đỉnh cuối
				AllPathButton(); // mở rộng ra, ta có thể chọn 2 đỉnh bất ký và in ra tất cả đường đi giữa 2 đỉnh đó

			}
		});


		AllPAthButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				omw.runDFS1(1, max, "Bai2"); // in tất cả các đường đi từ đỉnh đầu đên đỉnh cuối
				AllPathButton2(); // mở rộng ra, ta có thể chọn 2 đỉnh bất ký và in ra tất cả đường đi giữa 2 đỉnh đó

			}
		});

		QuestionsPathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					QuestionsPath();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // phần mô phỏng bài 3
			}
		});
		bai4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					QuestionsPath4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // phần mô phỏng bài 3
			}
		});

		bai5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					QuestionsPath5();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // phần mô phỏng bài 3
			}
		});

		WeightGraph.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnMyWay6 onMyWay6 = new OnMyWay6();
				onMyWay6.twoSelection();
			}
		});
		freezeButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setMouseManager(manager);
				freeze = !freeze;
				if (freeze) {
					buttonJPanel.add(freezeButton1);
					buttonJPanel.remove(unfreezeButton1);
				}
				else {
					buttonJPanel.add(unfreezeButton1);
					buttonJPanel.remove(freezeButton1);
				}
				frame.repaint();
				frame.revalidate();
			}
		});
		unfreezeButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setMouseManager(manager1);
				freeze = !freeze;
				if (freeze) {
					buttonJPanel.add(freezeButton1);
					buttonJPanel.remove(unfreezeButton1);
				}
				else {
					buttonJPanel.add(unfreezeButton1);
					buttonJPanel.remove(freezeButton1);
				}
				frame.repaint();
				frame.revalidate();
			}
		});
		radioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButton.isSelected()) {

					omw.getSwingViewer().disableAutoLayout();
					if (freeze)
						view.setMouseManager(manager1);
					else {
						view.setMouseManager(manager);
					}

				} else {

					omw.getSwingViewer().enableAutoLayout();
					if (freeze)
						view.setMouseManager(manager1);
					else {
						view.setMouseManager(manager);
					}

				}
			}
		});
		//D
//		Auto.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e){
//				AutoGo();
//			}
//		});
		frame.getContentPane().add(buttonJPanel, BorderLayout.SOUTH);
		frame.setTitle("Project OOP team 3");
		frame.setForeground(Color.YELLOW);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(view);
	}

	/// bài 3
	protected static void QuestionsPath() throws IOException {
		// TODO Auto-generated method stub
		JFrame AllPathFrame = new JFrame("Bai3"); // tạo 1 frame mới
		AllPathFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		AllPathFrame.getContentPane().setLayout(new  GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(); // gridbag of button
		GridBagConstraints gc = new GridBagConstraints();// gridbag of graph
		GridBagConstraints sc = new GridBagConstraints();// gridbag of scroll

		JScrollPane showPathScroll = new JScrollPane();
		JTextArea pathTxt = new JTextArea();
		showPathScroll.setViewportView(pathTxt);

		pathTxt.setText("Edge has passed:\n");
		JPanel vPanel = new JPanel();
		JPanel nPanel = new JPanel();
		JScrollPane vnScrollPane = new JScrollPane(nPanel);
		JScrollPane vPanelScoll = new JScrollPane(vPanel);
		vPanelScoll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JButton clearButton = new JButton("Clear"); // khôi phục lại đồ thị ban đầu
		JButton btnNewButton = new JButton(); // quay lại frame chọn bài
		JButton stopButton = new JButton("Stop"); // stop simulation graph
		JButton autoRandomButton = new JButton("Auto");
		JButton freezeButton = new JButton("Freeze");
		JButton unfreezeButton = new JButton("Unfreeze");
		BufferedImage menuBf = ImageIO.read(new File("label_button\\menu.png"));
		Image menudImg = menuBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon menuImg = new ImageIcon(menudImg);
		btnNewButton.setIcon(menuImg);

//		BufferedImage clearBf = ImageIO.read(new File("label_button\\reset.jpg"));
//		Image cleardImg = clearBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon clearImg = new ImageIcon(cleardImg);
//		clearButton.setIcon(clearImg);
//
//		BufferedImage stopBf = ImageIO.read(new File("label_button\\stop.png"));
//		Image stopdImg = stopBf.getScaledInstance(20, 30, Image.SCALE_SMOOTH);
//		ImageIcon stopImg = new ImageIcon(stopdImg);
//		stopButton.setIcon(stopImg);
		freezeButton.setBackground(Color.BLUE);
		unfreezeButton.setBackground(Color.LIGHT_GRAY);
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});
		btnNewButton.setBounds(10, 10, 208, 29);
		btnNewButton.setBackground(Color.CYAN);
		JLabel nodeLabel = new JLabel("Enter node");
		DefaultComboBoxModel nodeComboBoxModel = new DefaultComboBoxModel();
		nodeComboBoxModel.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel.addElement(i+"");
		}
		JComboBox nodeComboBox = new JComboBox(nodeComboBoxModel);
		nodeComboBox.setEditable(true);
		final JTextField nodeText = (JTextField) nodeComboBox.getEditor().getEditorComponent();
		nodeText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel.getSize(); ++i) {
					if((nodeComboBoxModel.getElementAt(i)+"").contains(nodeText.getText())) {
						filterNode.add(nodeComboBoxModel.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox.setSelectedItem(nodeText.getText());
					nodeComboBox.showPopup();
				} else {
					nodeComboBox.hidePopup();
				}
			}
		});

		JButton finishButton = new JButton("Finish");
//		BufferedImage finishBf = ImageIO.read(new File("label_button\\find.png"));
//		Image finishdImg = finishBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon finishImg = new ImageIcon(finishdImg);
//		finishButton.setIcon(finishImg);
		nPanel.add(btnNewButton);
		nPanel.add(clearButton);
		nPanel.add(stopButton);
		nPanel.add(nodeLabel);
		nPanel.add(nodeComboBox);
		nPanel.add(finishButton);
		nPanel.add(autoRandomButton);
		nPanel.add(freezeButton);
		nPanel.add(unfreezeButton);

		if (freeze) {
			nPanel.add(freezeButton);
			nPanel.remove(unfreezeButton);
		}
		else {
			nPanel.add(unfreezeButton);
			nPanel.remove(freezeButton);
		}

		freezeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setMouseManager(manager);
				freeze = !freeze;
				if (freeze) {
					nPanel.add(freezeButton);
					nPanel.remove(unfreezeButton);
				}
				else {
					nPanel.add(unfreezeButton);
					nPanel.remove(freezeButton);
				}
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
			}
		});
		unfreezeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setMouseManager(manager1);
				freeze = !freeze;
				if (freeze) {
					nPanel.add(freezeButton);
					nPanel.remove(unfreezeButton);
				}
				else {
					nPanel.add(unfreezeButton);
					nPanel.remove(freezeButton);
				}
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						check = false;
						try {
							omw.clear();
							pathTxt.setText("Edge has passed:\n");
							y1 = 0;
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							AllPathFrame.setVisible(false);
							buttonJPanel.remove(freezeButton);
							buttonJPanel.remove(unfreezeButton);
							if (freeze) {
								buttonJPanel.add(freezeButton1);
								buttonJPanel.remove(unfreezeButton1);
							}
							else {
								buttonJPanel.add(unfreezeButton1);
								buttonJPanel.remove(freezeButton1);
							}
							frame.remove(view);
							frame.add(view);
							frame.repaint();
							frame.revalidate();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});


		JButton[] vButtons = new JButton[max]; // tạo các button với vButtons[i] là đỉnh thứ i
		for(int i = 0; i < max; ++i) {
			vButtons[i] = new JButton(Integer.toString(i+1));
			vPanel.add(vButtons[i]);
		}
		JSplitPane splitGraph = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, showPathScroll, view);
		splitGraph.setOneTouchExpandable(true);
		splitGraph.setContinuousLayout(true);
		splitGraph.setDividerLocation(625);
		JSplitPane splitMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, vnScrollPane, vPanelScoll);
		splitMenu.setOneTouchExpandable(true);
		splitMenu.setContinuousLayout(true);
		splitMenu.setDividerLocation(625);
		LinkedList<Integer> secAdjList[];
		secAdjList = new LinkedList[max + 1];

		for (int i = 1; i <= max; i++) {
			secAdjList[i] = new LinkedList<Integer>();
			secAdjList[i] = (LinkedList) omw.adjLists[i].clone();

		}

		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Integer.parseInt(nodeText.getText()) > max) {
					JOptionPane.showMessageDialog(null, "Can't find node " + nodeText.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
					AllPathFrame.repaint();
					AllPathFrame.revalidate();
				}
				else  if(omw.getStack().contains(nodeText.getText())) {
					JOptionPane.showMessageDialog(null, "Node has chosen before", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
				else if (omw.getPlaceAdj().contains(Integer.parseInt(nodeText.getText())) || omw.getStack().size() == 0){
					System.out.println("?");
					try {
						omw.addOption(1, Integer.parseInt(nodeText.getText()));
					}  catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // đi tới đỉnh đó
					vPanel.removeAll();
					for(int j = 0; j < max; ++j) { // khôi phục lại các buton, để khi xóa các button ta sẽ có các button được xếp sếp theo thứ tự tăng dần

						vPanel.add(vButtons[j]);
					}
					/*vertex = omw.getVertex();
					for(int j = 0; j < max; ++j) {
						if(!vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
					}*/
					for(int j = 1; j <= max; ++j) {
						for(int k = 0; k < secAdjList[j].size(); ++k) {
							if(Integer.parseInt(nodeText.getText()) == secAdjList[j].get(k)) {
								secAdjList[j].remove(k);
							}
						}
					}

					aIntegers = omw.getPlaceAdj();
					for(int j = 0; j < max; ++j) {
						if(!aIntegers.contains(j+1)) { // những đỉnh nào mà không kề với đỉnh hiện tại sẽ xóa các button của các đỉnh đó đi
							vPanel.remove(vButtons[j]);
						}
					}
					vPanel.repaint();
					String a = omw.getLabel();
					pathTxt.setText(pathTxt.getText() + a);
//					AllPathFrame.getContentPane().add(vPanelScoll, c);
//					AllPathFrame.getContentPane().remove(view);
////					view = omw.getViewer();
//
//					AllPathFrame.getContentPane().add(view, gc);
					splitGraph.repaint();
					splitMenu.repaint();
					AllPathFrame.repaint();
					AllPathFrame.revalidate();
//					AllPathFrame.pack();
//					AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					AllPathFrame.setVisible(true);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "No path", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		vPanel.setForeground(Color.GREEN);


		gc.fill = GridBagConstraints.BOTH; // mở rộng panel cho khít với khoảng trống với cả chiều rộng và chiều cao
		gc.weightx = 0.5; // khoảng cách tương đối giữa các đối tượng
		gc.gridx = 0; // tọa độ (x, y) = 1, 1
		gc.gridy = 2;
		gc.ipadx =400;
		gc.ipady = 50; // mở rộng theo chiều dọc cả trên và dưới
//        gc.anchor = GridBagConstraints.EAST; // vị trí tương đối của panel trong tọa độ đó

		sc.fill = GridBagConstraints.BOTH;
		sc.weightx = 0.5;
		sc.gridx = 0;
		sc.gridy = 1;
		sc.ipady = 680;
		sc.anchor = GridBagConstraints.WEST;

//
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
//
//		AllPathFrame.getContentPane().add(nPanel, c);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridwidth = 2;
//		c.gridx = 1;
//		c.anchor = GridBagConstraints.PAGE_END;
//		AllPathFrame.getContentPane().add(showPathScroll, sc);
//
//		AllPathFrame.getContentPane().add(vPanelScoll, c);
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		AllPathFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) { // khi frame đóng, khôi phục lại đồ thị như ban đầu
//				AllPathFrame.dispose();
//				frame.setVisible(true);

				pathTxt.setText("Edge has passed:\n");
				omw.clear();
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
				frame.remove(view);
				frame.add(view);
				frame.repaint();
				frame.validate();
				frame.setVisible(true);
			}
		});


		AllPathFrame.add(splitMenu, gc);
		AllPathFrame.add(splitGraph, sc);
		AllPathFrame.add(menuBar, c);

//		AllPathFrame.getContentPane().add(view, gc);

		for(int i = 0; i < max; ++i) {
			vButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 1; i <= max; ++i) {
						if(e.getActionCommand().equals(Integer.toString(i))) {// xem đỉnh nào được nhấn hiện tại
							try {
								i3 = i;
								/*for(int j = 1; j <= max; ++j) {
									for(int k = 0; k < secAdjList[j].size(); ++k) {
										if(i == secAdjList[j].get(k)) {
											secAdjList[j].remove(k);
										}
									}
								}*/
								omw.addOption(1, i3); // đi tới đỉnh đó
								for(int j = 0; j < max; ++j) { // khôi phục lại các buton, để khi xóa các button ta sẽ có các button được xếp sếp theo thứ tự tăng dần

									vPanel.add(vButtons[j]);
								}
								/*vertex = omw.getVertex();
								for(int j = 0; j < max; ++j) {
									if(!vertex.contains(j+1)) {
										vPanel.remove(vButtons[j]);
									}
								}*/


								aIntegers = omw.getPlaceAdj();
								for(int j = 0; j < max; ++j) {
									if(!aIntegers.contains(j+1)) { // những đỉnh nào mà không kề với đỉnh hiện tại sẽ xóa các button của các đỉnh đó đi
										vPanel.remove(vButtons[j]);
									}
								}
								String a = omw.getLabel();
								pathTxt.setText(pathTxt.getText() + a);
//								AllPathFrame.getContentPane().add(vPanelScoll, c);
////								AllPathFrame.getContentPane().remove(view);
//////								view = omw.getViewer();
////
////								AllPathFrame.getContentPane().add(view, gc);
								nodeText.setText(i +"");
								splitGraph.repaint();
								splitMenu.repaint();
								AllPathFrame.repaint();
								AllPathFrame.revalidate();
//								AllPathFrame.pack();
//								AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//								AllPathFrame.setVisible(true);
								frame.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});

		}

		autoRandomButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed (ActionEvent e){
				// TODO Auto-generated method stub
				check=true;
				if (graph.getNode(nodeText.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Can't find node" + nodeText.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					if(omw.stack.size() == 0) {
						try {
							omw.addOption(1, Integer.parseInt(nodeText.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					omw.RandomPath = omw.RandomPath+"Random Path:" + "\n" +nodeText.getText();
					omw.graph.getNode(nodeText.getText()).setAttribute("ui.style","shape:circle;fill-color: green;size: 30px;");
					new javax.swing.Timer(1500, new ActionListener(){
						int begin =Integer.parseInt(nodeText.getText());
						int currentInt = begin;
						int preInt;
						Node currentNode = graph.getNode(begin - 1);

						@Override
						public void actionPerformed(ActionEvent e){
							currentNode.setAttribute("ui.style","shape:circle;fill-color: green;size: 30px;");

							if(secAdjList[currentInt].size()==0 || check == false){
								((javax.swing.Timer) e.getSource()).stop();
								return;
							}
							else{
								omw.RandomPath = omw.RandomPath + " -> ";

								Random rand = new Random();
								int randNum = rand.nextInt(secAdjList[currentInt].size());

								preInt = currentInt;

								currentInt = secAdjList[currentInt].get(randNum);
								currentNode = omw.graph.getNode(currentInt - 1);

								//secAdjList[preInt].remove(randNum);
								i3 = currentInt;
								String thisEdge = preInt + " " + currentInt;
								omw.graph.getEdge(thisEdge).setAttribute("ui.style", "fill-color: purple; size: 3px;");


								currentNode.setAttribute("ui.style", "shape:circle;fill-color: green;size: 30px;");


								try {
									omw.addOption(1, currentInt);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
//								System.out.println(omw.getLabel());
								pathTxt.setText(pathTxt.getText() + omw.getLabel());
								for(int j = 0; j < max; ++j) { // khôi phục lại các buton, để khi xóa các button ta sẽ có các button được xếp sếp theo thứ tự tăng dần

									vPanel.add(vButtons[j]);
								}

								/*vertex = omw.getVertex();
								for(int j = 0; j < max; ++j) {
									if(!vertex.contains(j+1)) {
										vPanel.remove(vButtons[j]);
									}
								}*/


								aIntegers = omw.getPlaceAdj();
								for(int j = 0; j < max; ++j) {
									if(!aIntegers.contains(j+1)) { // những đỉnh nào mà không kề với đỉnh hiện tại sẽ xóa các button của các đỉnh đó đi
										vPanel.remove(vButtons[j]);
									}
								}
								splitGraph.repaint();
								splitMenu.repaint();
								AllPathFrame.repaint();
								AllPathFrame.revalidate();
								nodeText.setText(currentInt + "");
								omw.RandomPath = omw.RandomPath + currentInt;
							}
						}


					}).start();

					//omw.GraphAuto(Integer.parseInt(nodeText.getText()));
					//textArea.setText(textArea.getText() + omw.RandomPath);
				}
			}


		});


		clearButton.addActionListener(new ActionListener() { // khôi phục lại đồ thị

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				check = false;
				omw.clear();
				y1 = 0;
				for(int j = 0; j < max; ++j) {
					if(vertex.contains(j+1)) {
						vPanel.remove(vButtons[j]);
					}
					vPanel.add(vButtons[j]);
				}
				pathTxt.setText("Edge has passed:\n");
				splitGraph.repaint();
				splitMenu.repaint();
//				AllPathFrame.getContentPane().add(vPanelScoll, c);
//				AllPathFrame.getContentPane().remove(view);
////				view = omw.getViewer();
//				AllPathFrame.add(view, gc);
				nodeText.setText("");
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
//				AllPathFrame.pack();
//				AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				AllPathFrame.setVisible(true);
				frame.dispose();
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				check=false;
				aIntegers = omw.getPlaceAdj();
				for(int j = 0; j < max; ++j) {
					if(aIntegers.contains(j+1)) { // những đỉnh nào mà không kề với đỉnh hiện tại sẽ xóa các button của các đỉnh đó đi
						vPanel.remove(vButtons[j]);
					}
				}
				splitGraph.repaint();
				splitMenu.repaint();
//				AllPathFrame.getContentPane().add(vPanelScoll, c);
//				AllPathFrame.getContentPane().remove(view);
////				view = omw.getViewer();
//				AllPathFrame.add(view, gc);
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
//				AllPathFrame.pack();
//				AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				AllPathFrame.setVisible(true);
				frame.dispose();
			}
		});
		AllPathFrame.pack();
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setVisible(true);
		frame.dispose();
	}

	public static void AllPathButton() { // bài 2
		// TODO Auto-generated method stub
		c = new Integer[max + 1];
		JFrame AllPathFrame = new JFrame();
		JPanel vPanel = new JPanel();
		JButton btnNewButton = new JButton("Menu");
		BufferedImage menuBf = null;
		try {
			menuBf = ImageIO.read(new File("label_button\\menu.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image menudImg = menuBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon menuImg = new ImageIcon(menudImg);
		btnNewButton.setIcon(menuImg);
		btnNewButton.setBounds(10, 10, 208, 29);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							omw.clear();
							frame.getContentPane().add(view);
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							frame.setVisible(true);
							AllPathFrame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		vPanel.add(btnNewButton);
		JLabel nodeLabel1 = new JLabel("Enter node 1st");
		JLabel nodeLabel2 = new JLabel("Enter node 2nd");
		DefaultComboBoxModel nodeComboBoxModel1 = new DefaultComboBoxModel();
		nodeComboBoxModel1.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel1.addElement(i+"");
		}
		JComboBox nodeComboBox1 = new JComboBox(nodeComboBoxModel1);
		nodeComboBox1.setEditable(true);
		final JTextField nodeText1 = (JTextField) nodeComboBox1.getEditor().getEditorComponent();
		nodeText1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel1.getSize(); ++i) {
					if((nodeComboBoxModel1.getElementAt(i)+"").contains(nodeText1.getText())) {
						filterNode.add(nodeComboBoxModel1.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox1.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox1.setSelectedItem(nodeText1.getText());
					nodeComboBox1.showPopup();
				} else {
					nodeComboBox1.hidePopup();
				}
			}
		});
		DefaultComboBoxModel nodeComboBoxModel2 = new DefaultComboBoxModel();
		nodeComboBoxModel2.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel2.addElement(i+"");
		}
		JComboBox nodeComboBox2 = new JComboBox(nodeComboBoxModel2);
		nodeComboBox2.setEditable(true);
		final JTextField nodeText2 = (JTextField) nodeComboBox2.getEditor().getEditorComponent();
		nodeText2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel2.getSize(); ++i) {
					if((nodeComboBoxModel2.getElementAt(i)+"").contains(nodeText2.getText())) {
						filterNode.add(nodeComboBoxModel2.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox2.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox2.setSelectedItem(nodeText2.getText());
					nodeComboBox2.showPopup();
				} else {
					nodeComboBox2.hidePopup();
				}
			}
		});
		JButton finishButton = new JButton("Finish");
		BufferedImage finishBf = null;
		try {
			finishBf = ImageIO.read(new File("label_button\\find.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image finishdImg = finishBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon finishImg = new ImageIcon(finishdImg);
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});
		finishButton.setIcon(finishImg);
		vPanel.add(nodeLabel1);
		vPanel.add(nodeComboBox1);
		vPanel.add(nodeLabel2);
		vPanel.add(nodeComboBox2);
		vPanel.add(finishButton);
		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				omw.graphPaint();
				String t1 = nodeText1.getText(), t2 = nodeText2.getText();
				if(graph.getNode(t1) == null || graph.getNode(t2) == null) {
					if(graph.getNode(t1) == null && graph.getNode(t2) != null) {
						JOptionPane.showMessageDialog(null, "Can't find node" + t1 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(graph.getNode(t2) == null && graph.getNode(t1) != null) {
						JOptionPane.showMessageDialog(null, "Can't find node" + t2 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't find node" + t1 + " " + t2 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					omw.runDFS(Integer.parseInt(t1) , Integer.parseInt(t2), "path between vertex " + t1 + " and vertex " +t2 );
				}
			}
		});
		AllPathFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				AllPathFrame.dispose();
			}
		});
//		setLabel(AllPathFrame);
		AllPathFrame.add(menuBar, BorderLayout.NORTH);
		AllPathFrame.getContentPane().add(vPanel, BorderLayout.SOUTH);
		AllPathFrame.getContentPane().add(view);
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AllPathFrame.pack();
		AllPathFrame.setVisible(true);
		frame.dispose();

	}

	public static void AllPathButton2() { // ài 2
		// TODO Auto-generated method stub
		c = new Integer[max + 1];
		JFrame AllPathFrame = new JFrame();
		JPanel vPanel = new JPanel();
		JButton btnNewButton = new JButton("Menu");
		BufferedImage menuBf = null;
		try {
			menuBf = ImageIO.read(new File("label_button\\menu.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image menudImg = menuBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon menuImg = new ImageIcon(menudImg);
		btnNewButton.setIcon(menuImg);
		btnNewButton.setBounds(10, 10, 208, 29);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							omw.clear();
							frame.getContentPane().add(view);
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							frame.setVisible(true);
							AllPathFrame.dispose();
							omw.graphPaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		vPanel.add(btnNewButton);
		JLabel nodeLabel1 = new JLabel("Enter node 1st");
		JLabel nodeLabel2 = new JLabel("Enter node 2nd");
		DefaultComboBoxModel nodeComboBoxModel1 = new DefaultComboBoxModel();
		nodeComboBoxModel1.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel1.addElement(i+"");
		}
		JComboBox nodeComboBox1 = new JComboBox(nodeComboBoxModel1);
		nodeComboBox1.setEditable(true);
		final JTextField nodeText1 = (JTextField) nodeComboBox1.getEditor().getEditorComponent();
		nodeText1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel1.getSize(); ++i) {
					if((nodeComboBoxModel1.getElementAt(i)+"").contains(nodeText1.getText())) {
						filterNode.add(nodeComboBoxModel1.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox1.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox1.setSelectedItem(nodeText1.getText());
					nodeComboBox1.showPopup();
				} else {
					nodeComboBox1.hidePopup();
				}
			}
		});
		DefaultComboBoxModel nodeComboBoxModel2 = new DefaultComboBoxModel();
		nodeComboBoxModel2.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel2.addElement(i+"");
		}
		JComboBox nodeComboBox2 = new JComboBox(nodeComboBoxModel2);
		nodeComboBox2.setEditable(true);
		final JTextField nodeText2 = (JTextField) nodeComboBox2.getEditor().getEditorComponent();
		nodeText2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel2.getSize(); ++i) {
					if((nodeComboBoxModel2.getElementAt(i)+"").contains(nodeText2.getText())) {
						filterNode.add(nodeComboBoxModel2.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox2.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox2.setSelectedItem(nodeText2.getText());
					nodeComboBox2.showPopup();
				} else {
					nodeComboBox2.hidePopup();
				}
			}
		});
		JButton finishButton = new JButton("Finish");
		BufferedImage finishBf = null;
		try {
			finishBf = ImageIO.read(new File("label_button\\find.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image finishdImg = finishBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon finishImg = new ImageIcon(finishdImg);
		finishButton.setIcon(finishImg);

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});

		vPanel.add(nodeLabel1);
		vPanel.add(nodeComboBox1);
		vPanel.add(nodeLabel2);
		vPanel.add(nodeComboBox2);
		vPanel.add(finishButton);
		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t1 = nodeText1.getText(), t2 = nodeText2.getText();
				if(graph.getNode(t1) == null || graph.getNode(t2) == null) {
					if(graph.getNode(t1) == null && graph.getNode(t2) != null) {
						JOptionPane.showMessageDialog(null, "Can't find node" + t1 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(graph.getNode(t2) == null && graph.getNode(t1) != null) {
						JOptionPane.showMessageDialog(null, "Can't find node" + t2 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Can't find node" + t1 + " " + t2 + "!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					omw.runDFS1(Integer.parseInt(t1) , Integer.parseInt(t2), "path between vertex " + t1 + " and vertex " +t2 );
				}
			}
		});
		AllPathFrame.add(menuBar, BorderLayout.NORTH);
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.getContentPane().add(vPanel, BorderLayout.SOUTH);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		AllPathFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				AllPathFrame.dispose();
			}
		});
//		setLabel(AllPathFrame);
		AllPathFrame.getContentPane().add(view);
		AllPathFrame.pack();
		AllPathFrame.setVisible(true);
		frame.dispose();

	}

	public static void prepare() throws IOException { // đọc file, xử lý để in ra đồ thị từ file đó
//		System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing.util.Display");
//		graph = new SingleGraph("Project");
//		graph.setAttribute( "ui.stylesheet", styleSheet );
//		graph.setAttribute( "ui.antialias" );
//		graph.setAttribute( "ui.quality" );
//		graph.setStrict(false);
//		graph.setAutoCreate( true );
//
		// Creates an array of character
		char[] array = new char[100];
		// Read file into an arraylist
		ArrayList<String> listOfLines = new ArrayList<>();
		BufferedReader bufReader;
		try {
			//doc file text theo dong
			bufReader = new BufferedReader(new FileReader(
					path));
			String line = bufReader.readLine();
			//voi moi dong:
			//add gia tri dau tien vao danh sach cac dinh co it nhat 1 dinh ke hasNext              (1)
			//put vao adjmap (hashmap) ten dinh va danh sach cac dinh ke voi no.                    (2)
			//them canh vao graph tu dong do                                                        (3)
			//tim dinh dich

			while (line != null) {
				listOfLines.add(line);
				line = bufReader.readLine();
			}
			bufReader.close();
		} catch (IOException e) {
		}

		size = listOfLines.size(); // số dòng trong file


		allIntArr = new int[size][];

		//Read to list of integers for each line
		for (int i = 0; i < size; i++) {
			arrOfStr = listOfLines.get(i).split(" "); // mỗi dòng sẽ tách ra thành các phần tử vào lưu vào mảng tương ứng
			int arrOfStrlength = arrOfStr.length;
			allIntArr[i] = new int[arrOfStrlength];

			for (int j = 0; j < arrOfStrlength; j++) {
				allIntArr[i][j] = Integer.parseInt(arrOfStr[j]);

			}
//        	for (int j = 1; j < arrOfStrlength; j++) {
//        			graph.addEdge(arrOfStr[0] + arrOfStr[j], arrOfStr[0], arrOfStr[j], true); // true: đồ thị có hướng
//
//
//        	}
			for (int j = 0; j < arrOfStrlength; j++) { // tìm đỉnh có số hiệu lớn nhất
				if (max < allIntArr[i][j])
					max = allIntArr[i][j];
			}
			//find max


		}
//        g = new DFS(max); // add các cạnh vào DFS để chạy thuật toán đó
//        for (int i = 0; i < size; i++) {
//        	for (int j = 1; j < allIntArr[i].length; j++) {
//        		g.addEdge(allIntArr[i][0], allIntArr[i][j]);
//        	}
//        }

		//Max is the numbers of node of graph
		/////////////////////////////////////
		/////////////////////////////////////
		//g: save data of graph
		omw = new OnMyWayabc(max); //thêm các cạnh vào để chạy thuật toán bài 3
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < allIntArr[i].length; j++) {
				omw.addEdge(allIntArr[i][0], allIntArr[i][j]);
			}
		}
		omw.runner();
		graph = omw.getGraph();
		view = omw.getViewer();
		omw4 = new OnMyWay(max);
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < allIntArr[i].length; j++) {
				omw4.addEdge(allIntArr[i][0], allIntArr[i][j]);
			}
		}
		omw4.runner(graph, view);

		omw5 = new OnMyWay2(max);
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < allIntArr[i].length; j++) {
				omw5.addEdge(allIntArr[i][0], allIntArr[i][j]);
			}
		}
		omw5.runner(graph, view);

		Node[] e = new Node[max+1];

//        for(int i = 1; i <= max; ++i) {
//
//        	graph.addNode(Integer.toString(i));
//        	e[i] = graph.getNode(Integer.toString(i));
//        	e[i].setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 30px;");
//    		e[i].setAttribute("ui.label", Integer.toString(i));
//
//        }
		view.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				project.zoomGraphMouseWheelMoved(mwe, view);

			}
		});

		view.removeMouseListener(view.getMouseListeners()[0]);
		view.setCursor(new Cursor(Cursor.HAND_CURSOR));
		camera = view.getCamera();
		camera.setAutoFitView(true);
//      view.addMouseMotionListener(new MouseMotionListener() {
//
//
//          @Override
//          public void mouseDragged(MouseEvent mouseEvent) {
////              MouseDraggedGraph(mouseEvent, view);
//          }
//
//          @Override
//          public void mouseMoved(MouseEvent mouseEvent) {
//             MouseMoveGrapg(mouseEvent, view);
//          }
//      });
//
		view4 = omw4.getViewer();
		view4.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				project.zoomGraphMouseWheelMoved(mwe, view4);
			}
		});

		view5 = omw5.getViewer();
		view5.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				project.zoomGraphMouseWheelMoved(mwe, view5);
			}
		});
		view.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent mwe) {
				if (mwe.getKeyChar() == 'c') {
					String result;
					result = JOptionPane.showInputDialog("Saved as: ");
					if(result != null) {
						omw.takePicture(result);
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					}

				}
				else if (mwe.getKeyChar() == 's') {

					String result;
					result = JOptionPane.showInputDialog("Saved as: ");
					if(result != null) {
						BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
						Graphics g = bi.createGraphics();
						view.print(g);
						g.dispose();
						try {
							ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
							JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				else {
					String s = "1. Type \'C\' to take picture of the whole graph\n"
							+ "2. Type \'S\' to take picture of the the view\n";
					JOptionPane.showMessageDialog(null, s);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
	// đây là đặt nhãn dán cho 1 frame bất kỳ ở phía trên cùng của frame
	public static void setLabel(JFrame frame) {
		JLabel showGraphLabel = new JLabel("PROJECT JAVA");
		showGraphLabel.setFont(new Font("Helvetica", Font.PLAIN, 30));
		showGraphLabel.setForeground(Color.RED);

		showGraphLabel.setHorizontalAlignment(SwingConstants.CENTER);

		frame.add(showGraphLabel, BorderLayout.NORTH);
	}
	public static void zoomGraphMouseWheelMoved(MouseWheelEvent mwe, ViewPanel view){
		if (Event.ALT_MASK != 0) {
			if (mwe.getWheelRotation() > 0) {
				double new_view_percent = view.getCamera().getViewPercent() + 0.05;
				view.getCamera().setViewPercent(new_view_percent);
			} else if (mwe.getWheelRotation() < 0) {
				double current_view_percent = view.getCamera().getViewPercent();
				if(current_view_percent > 0.05){
					view.getCamera().setViewPercent(current_view_percent - 0.05);
				}
			}
		}
	}

	public static void MouseMoveGrapg(MouseEvent mouseEvent, ViewPanel view) {

	}
	static MouseManager manager1 = new DefaultMouseManager() {

	};

	static MouseManager manager = new DefaultMouseManager() {

		@Override
		public void mouseDragged(MouseEvent mouseEvent) {
			int currentX = mouseEvent.getX();
			int currentY = mouseEvent.getY();

			Point3 pointView = camera.getViewCenter();

			if (preX != -1 && preY != -1) {
				if (preX < currentX) {
					pointView.x -= 0.01;
				}
				else if (preX > currentX) {
					pointView.x += 0.01;
				}

				if (preY < currentY) {
					pointView.y += 0.01;
				}
				else if (preY > currentY) {
					pointView.y -= 0.01;
				}
			}
			camera.setViewCenter(pointView.x, pointView.y, pointView.z);

			preX = currentX;
			preY = currentY;
		}

		@Override
		protected void mouseButtonPress(MouseEvent event) {
			super.mouseButtonPress(event);

//		        System.out.println("Press");
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			super.mouseClicked(event);
//		        System.out.println("Clicked");
		}

		@Override
		public void mousePressed(MouseEvent event) {
			super.mousePressed(event);

		}
		public void mouseMoved(MouseEvent mouseEvent) {
			GraphicElement node =  ((View) view).findGraphicElementAt(EnumSet.of(InteractiveElement.NODE), mouseEvent.getX(), mouseEvent.getY());
			if (node != null) {
				((Component) view).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			else {
				((Component) view).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}	          }
	};

	public static String styleSheet =
			"graph {"+
					"	canvas-color: black;"+
					"		fill-mode: gradient-vertical;"+
					"		fill-color: black, #004;"+
					"		padding: 60px;"+
					"	}"+
					"node {"+
					"	shape: circle;"+
					"	size: 14px;"+
					"	fill-mode: gradient-radial;"+
					"	fill-color: #FFFA, #FFF0;"+
					"	stroke-mode: none;"+
					"	shadow-mode: gradient-radial;"+
					"	shadow-color: #FFF9, #FFF0;"+
					"	shadow-width: 10px;"+
					"	shadow-offset: 0px, 0px;"+
					"}"+
					"node:clicked {"+
					"	fill-color: #F00A, #F000;"+
					"}"+
					"node:selected {"+
					"	fill-color: #00FA, #00F0;"+
					"}"+
					"edge {"+
					"	shape: line;"+
					"	size: 1px;"+
					"	fill-color: #FFF3;"+
					"	fill-mode: plain;"+
					"	arrow-shape: none;"+
					"}"+
					"sprite {"+
					"	shape: circle;"+
					"	fill-mode: gradient-radial;"+
					"	fill-color: #FFF8, #FFF0;"+
					"}";
	protected static void QuestionsPath4() throws IOException {
		// TODO Auto-generated method stub

		JFrame AllPathFrame = new JFrame("Bai4");
		JPanel vPanel = new JPanel();
		JScrollPane vPanelScoll = new JScrollPane(vPanel);
		vPanelScoll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton clearButton = new JButton("Clear");
		JButton backButton = new JButton("Back");
		JButton btnNewButton = new JButton();
		BufferedImage menuBf = ImageIO.read(new File("label_button\\menu.png"));
		Image menudImg = menuBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon menuImg = new ImageIcon(menudImg);
		btnNewButton.setIcon(menuImg);

//		BufferedImage clearBf = ImageIO.read(new File("label_button\\reset.jpg"));
//		Image cleardImg = clearBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon clearImg = new ImageIcon(cleardImg);
//		clearButton.setIcon(clearImg);
//
//		BufferedImage backBf = ImageIO.read(new File("label_button\\back.png"));
//		Image backdImg = backBf.getScaledInstance(20, 30, Image.SCALE_SMOOTH);
//		ImageIcon backImg = new ImageIcon(backdImg);
//		backButton.setIcon(backImg);
		btnNewButton.setBounds(10, 10, 208, 29);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							omw4.clear();
							omw.graphPaint();
							frame.getContentPane().add(view);
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							frame.setVisible(true);
							AllPathFrame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		//Enter node
		JLabel nodeLabel = new JLabel("Enter node");
		DefaultComboBoxModel nodeComboBoxModel = new DefaultComboBoxModel();
		nodeComboBoxModel.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel.addElement(i+"");
		}
		JComboBox nodeComboBox = new JComboBox(nodeComboBoxModel);
		nodeComboBox.setEditable(true);
		final JTextField nodeText = (JTextField) nodeComboBox.getEditor().getEditorComponent();
		nodeText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel.getSize(); ++i) {
					if((nodeComboBoxModel.getElementAt(i)+"").contains(nodeText.getText())) {
						filterNode.add(nodeComboBoxModel.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox.setSelectedItem(nodeText.getText());
					nodeComboBox.showPopup();
				} else {
					nodeComboBox.hidePopup();
				}
			}
		});

		//Aim to
		JLabel nodeLabel2 = new JLabel("Aim to");
		DefaultComboBoxModel nodeComboBoxModel2 = new DefaultComboBoxModel();
		nodeComboBoxModel2.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel2.addElement(i+"");
		}
		JComboBox nodeComboBox2 = new JComboBox(nodeComboBoxModel2);
		nodeComboBox2.setEditable(true);
		final JTextField nodeText2 = (JTextField) nodeComboBox2.getEditor().getEditorComponent();
		nodeText2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode2 = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel2.getSize(); ++i) {
					if((nodeComboBoxModel2.getElementAt(i)+"").contains(nodeText2.getText())) {
						filterNode2.add(nodeComboBoxModel2.getElementAt(i)+"");
					}
				}
				if(filterNode2.size() >0) {
					nodeComboBox2.setModel(new DefaultComboBoxModel(filterNode2.toArray()));
					nodeComboBox2.setSelectedItem(nodeText2.getText());
					nodeComboBox2.showPopup();
				} else {
					nodeComboBox2.hidePopup();
				}
			}
		});
		nodeText.setText(1+"");
		nodeText2.setText(max +"");
		JButton finishButton = new JButton("Finish");
		JButton hintButton = new JButton("Hint");
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});
//		BufferedImage finishBf = ImageIO.read(new File("label_button\\find.png"));
//		Image finishdImg = finishBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon finishImg = new ImageIcon(finishdImg);
//		finishButton.setIcon(finishImg);
		vPanel.add(btnNewButton);
		//vPanel.add(clearButton);
		vPanel.add(backButton);
		vPanel.add(nodeLabel);
		vPanel.add(nodeComboBox);
		vPanel.add(finishButton);
		vPanel.add(nodeLabel2);
		vPanel.add(nodeComboBox2);
		vPanel.add(hintButton);

		JButton[] vButtons = new JButton[max];
		for(int i = 0; i < max; ++i) {
			vButtons[i] = new JButton(Integer.toString(i+1));
			vPanel.add(vButtons[i]);
		}

		vPanel.setForeground(Color.GREEN);

		AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		AllPathFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				//AllPathFrame.dispose();
				//omw4.clear();
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
			}
		});
//		setLabel(AllPathFrame);

		//getView(AllPathFrame);

		//view = omw4.getViewer();
		AllPathFrame.add(view4);

		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(graph.getNode(nodeText.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Can't find node " + nodeText.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {

						omw4.addOption(1, Integer.parseInt(nodeText.getText()));
						omw4.predictPath(Integer.parseInt(nodeText2.getText()));
					}  catch (IOException e1) {
						e1.printStackTrace();
					} // đi tới đỉnh đó
					for(int j = 0; j < max; ++j) {

						vPanel.add(vButtons[j]);
					}
					new Timer(3000, new ActionListener() {
						private int cnt = 0;
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							omw4.clearPredictPath();

//								System.out.println("???");
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							((javax.swing.Timer) e.getSource()).stop();
							return;

//								AllPathFrame.repaint();
//								AllPathFrame.revalidate();


						}
					}).start();
					vertex = omw4.getVertex();
					for(int j = 0; j < max; ++j) {
						if(!vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
					}
					vPanel.repaint();
//					AllPathFrame.getContentPane().add(vPanelScoll);
//					AllPathFrame.getContentPane().remove(view4);
////					view = omw.getViewer();
//
//					AllPathFrame.getContentPane().add(view4);
					AllPathFrame.repaint();
					AllPathFrame.revalidate();
//					AllPathFrame.pack();
//					AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					AllPathFrame.setVisible(true);
					frame.dispose();
					i3 = Integer.parseInt(nodeText.getText());
				}
			}
		});

		hintButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(graph.getNode(nodeText2.getText()) == null) {
//					JOptionPane.showMessageDialog(null, "Can't move to this node " + nodeText.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					omw4.predictPath(Integer.parseInt(nodeText2.getText()));
//					System.out.println(nodeText2.getText());
					new Timer(3000, new ActionListener() {
						private int cnt = 0;
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							omw4.clearPredictPath();

//								System.out.println("???");
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							((javax.swing.Timer) e.getSource()).stop();
							return;

//								AllPathFrame.repaint();
//								AllPathFrame.revalidate();


						}
					}).start();

					AllPathFrame.repaint();
					AllPathFrame.revalidate();
					frame.dispose();
				}
			}
		});
		for(int i = 0; i < max; ++i) {
			vButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 1; i <= max; ++i) {

						if(e.getActionCommand().equals(Integer.toString(i))) {
							try {
								i3 = i;
								nodeText.setText(i3+"");
								omw4.addOption(1, i3);
								omw4.predictPath(Integer.parseInt(nodeText2.getText()));
								new Timer(3000, new ActionListener() {
									private int cnt = 0;
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub

										omw4.clearPredictPath();

//											System.out.println("???");
										AllPathFrame.repaint();
										AllPathFrame.revalidate();
										((javax.swing.Timer) e.getSource()).stop();
										return;

//											AllPathFrame.repaint();
//											AllPathFrame.revalidate();


									}
								}).start();
//								omw4.addOption(2, Integer.parseInt(nodeText2.getText()));
								for(int j = 0; j < max; ++j) {

									vPanel.add(vButtons[j]);
								}
								vertex = omw4.getVertex();
								for(int j = 0; j < max; ++j) {
									if(!vertex.contains(j+1)) {
										vPanel.remove(vButtons[j]);
									}
								}
//
//								AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
//								AllPathFrame.getContentPane().remove(view4);
//								//view = omw4.getViewer();
//								AllPathFrame.add(view4);
								AllPathFrame.repaint();
								AllPathFrame.revalidate();
								//AllPathFrame.pack();
								//AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								//AllPathFrame.setVisible(true);
								//frame.dispose();
								i3 = i;
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});

		}

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					omw4.addOption(0, i3);
					omw4.predictPath(Integer.parseInt(nodeText2.getText()));
					nodeText.setText(i3+"");
					vertex = omw4.getVertex();
					new Timer(3000, new ActionListener() {
						private int cnt = 0;
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub

							omw4.clearPredictPath();

//								System.out.println("???");
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							((javax.swing.Timer) e.getSource()).stop();
							return;

//								AllPathFrame.repaint();
//								AllPathFrame.revalidate();


						}
					}).start();
					for(int j = 0; j < max; ++j) {
						if(vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
						vPanel.add(vButtons[j]);

					}

					for(int j = 0; j < max; ++j) {
						if(!vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
					}
//					AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
//					AllPathFrame.getContentPane().remove(view4);
//					//view = omw4.getViewer();
//					AllPathFrame.add(view4);
					AllPathFrame.repaint();
					AllPathFrame.revalidate();
					//AllPathFrame.pack();
					//AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//AllPathFrame.setVisible(true);
					//frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				omw4.clear();
				y1 = 0;
				new Timer(3000, new ActionListener() {
					private int cnt = 0;
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						omw4.clearPredictPath();

//							System.out.println("???");
						AllPathFrame.repaint();
						AllPathFrame.revalidate();
						((javax.swing.Timer) e.getSource()).stop();
						return;

//							AllPathFrame.repaint();
//							AllPathFrame.revalidate();


					}
				}).start();
				for(int j = 0; j < max; ++j) {
					if(vertex.contains(j+1)) {
						vPanel.remove(vButtons[j]);
					}
					vPanel.add(vButtons[j]);
				}
//				AllPathFrame.getContentPane().add(vPanel, BorderLayout.SOUTH);
//				AllPathFrame.getContentPane().remove(view);
//				//view = omw4.getViewer();
//				AllPathFrame.add(view);
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
				//AllPathFrame.pack();
				//AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				//AllPathFrame.setVisible(true);
				frame.dispose();
			}
		});

		AllPathFrame.add(menuBar, BorderLayout.NORTH);
		AllPathFrame.pack();
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setVisible(true);
		frame.dispose();
	}

	protected static void QuestionsPath5() throws IOException {
		// TODO Auto-generated method stub
		JFrame AllPathFrame = new JFrame("Bai5");
		JPanel vPanel = new JPanel();
		JScrollPane vPanelScoll = new JScrollPane(vPanel);
		vPanelScoll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton clearButton = new JButton("Clear");
		JButton backButton = new JButton("Back");
		JButton btnNewButton = new JButton();

		BufferedImage menuBf = ImageIO.read(new File("label_button\\menu.png"));
		Image menudImg = menuBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon menuImg = new ImageIcon(menudImg);
		btnNewButton.setIcon(menuImg);
//
//		BufferedImage clearBf = ImageIO.read(new File("label_button\\reset.jpg"));
//		Image cleardImg = clearBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon clearImg = new ImageIcon(cleardImg);
//		clearButton.setIcon(clearImg);
//
//		BufferedImage backBf = ImageIO.read(new File("label_button\\back.png"));
//		Image backdImg = backBf.getScaledInstance(20, 30, Image.SCALE_SMOOTH);
//		ImageIcon backImg = new ImageIcon(backdImg);
//		backButton.setIcon(backImg);
		btnNewButton.setBounds(10, 10, 208, 29);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
//							omw4.clear();
							frame.remove(view);
							omw5.clear();
							omw.graphPaint();
							frame.getContentPane().add(view);
							AllPathFrame.repaint();
							AllPathFrame.revalidate();
							frame.setVisible(true);
							AllPathFrame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JLabel nodeLabel = new JLabel("Enter node");
		DefaultComboBoxModel nodeComboBoxModel = new DefaultComboBoxModel();
		nodeComboBoxModel.addElement("");
		for(int i = 1; i <= max; ++i) {
			nodeComboBoxModel.addElement(i+"");
		}
		JComboBox nodeComboBox = new JComboBox(nodeComboBoxModel);
		nodeComboBox.setEditable(true);
		final JTextField nodeText = (JTextField) nodeComboBox.getEditor().getEditorComponent();
		nodeText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				LinkedList<String> filterNode = new LinkedList<String>();
				for(int i = 0; i < nodeComboBoxModel.getSize(); ++i) {
					if((nodeComboBoxModel.getElementAt(i)+"").contains(nodeText.getText())) {
						filterNode.add(nodeComboBoxModel.getElementAt(i)+"");
					}
				}
				if(filterNode.size() >0) {
					nodeComboBox.setModel(new DefaultComboBoxModel(filterNode.toArray()));
					nodeComboBox.setSelectedItem(nodeText.getText());
					nodeComboBox.showPopup();
				} else {
					nodeComboBox.hidePopup();
				}
			}
		});
		JButton finishButton = new JButton("Finish");
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		JMenuItem screen1 = new JMenuItem("Take picture");
		JMenuItem screen2 = new JMenuItem("Take screen shot");
		JMenuItem pictureFile = new JMenuItem("Open picture file");
		file.add(screen1);
		file.add(screen2);
		file.add(pictureFile);
		screen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					omw.takePicture(result);
					JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
				}
			}
		});
		screen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String result;
				result = JOptionPane.showInputDialog("Saved as: ");
				if(result != null) {
					BufferedImage bi = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					view.print(g);
					g.dispose();
					try {
						ImageIO.write(bi, "png", new File("pic_graph\\"+result+".png"));
						JOptionPane.showMessageDialog(null, "Your image has been saved as "+result+".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pictureFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try
				{

					File file = new File("pic_graph");
					if(!Desktop.isDesktopSupported())
					{
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if(file.exists())
						desktop.open(file);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		JCheckBoxMenuItem styleItem = new JCheckBoxMenuItem("StyleSheet");
		JMenuItem freezeItem = new JMenuItem("Freeze");
		JCheckBoxMenuItem stopItem = new JCheckBoxMenuItem("Stop auto layout");
		edit.add(styleItem);
		edit.add(freezeItem);
		edit.add(stopItem);
		freezeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (freezeItem.getText() == "Freeze") {
					view.setMouseManager(manager);
					freezeItem.setText("Unfreeze");
				}
				else {
					view.setMouseManager(manager1);
					freezeItem.setText("Freeze");
				}
				frame.repaint();
				frame.revalidate();
			}
		});

		stopItem.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (stopItem.getState()) {
					omw.getSwingViewer().disableAutoLayout();
				}
				else {
					omw.getSwingViewer().enableAutoLayout();
				}
			}
		});
		styleItem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(styleItem.getState()) {
					omw.addStyleSheet(1);
				} else {
					omw.addStyleSheet(0);
				}
			}
		});
//		BufferedImage finishBf = null;
//		try {
//			finishBf = ImageIO.read(new File("label_button\\find.png"));
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		Image finishdImg = finishBf.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon finishImg = new ImageIcon(finishdImg);
//		finishButton.setIcon(finishImg);
		vPanel.add(btnNewButton);
		//vPanel.add(clearButton);
		vPanel.add(backButton);
		vPanel.add(nodeLabel);
		vPanel.add(nodeComboBox);
		vPanel.add(finishButton);

		JButton[] vButtons = new JButton[max];
		for(int i = 0; i < max; ++i) {
			vButtons[i] = new JButton(Integer.toString(i+1));
			vPanel.add(vButtons[i]);
		}

		vPanel.setForeground(Color.GREEN);
		AllPathFrame.add(menuBar, BorderLayout.NORTH);
		AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		AllPathFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				//AllPathFrame.dispose();
				//omw4.clear();
				AllPathFrame.repaint();
				AllPathFrame.revalidate();
			}
		});
//		setLabel(AllPathFrame);

		//getview5(AllPathFrame);

		//view5 = omw5.getview5er();
		AllPathFrame.add(view5);

		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(graph.getNode(nodeText.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Can't find node " + nodeText.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {

						omw5.addOption(1, Integer.parseInt(nodeText.getText()));
						for(int j = 0; j < max; ++j) {

							vPanel.add(vButtons[j]);
						}
						/*vertex = omw5.getVertex();
						for(int j = 0; j < max; ++j) {
							if(!vertex.contains(j+1)) {
								vPanel.remove(vButtons[j]);
							}
						}*/

						aIntegers = omw5.getPlaceAdj();
						for(int j = 0; j < max; ++j) {
							if(!aIntegers.contains(j+1)) {
								vPanel.remove(vButtons[j]);
							}
						}
						vPanel.repaint();
						AllPathFrame.getContentPane().add(vPanelScoll);
						AllPathFrame.getContentPane().remove(view5);
//						view = omw.getViewer();

						AllPathFrame.getContentPane().add(view5);
						AllPathFrame.repaint();
						AllPathFrame.revalidate();
//						AllPathFrame.pack();
//						AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//						AllPathFrame.setVisible(true);
						frame.dispose();
					}  catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // đi tới đỉnh đó

				}
			}
		});

		for(int i = 0; i < max; ++i) {
			vButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 1; i <= max; ++i) {
						if(e.getActionCommand().equals(Integer.toString(i))) {
							try {
								i3 = i;
								omw5.addOption(1, i3);
								for(int j = 0; j < max; ++j) {

									vPanel.add(vButtons[j]);
								}
								/*vertex = omw5.getVertex();
								for(int j = 0; j < max; ++j) {
									if(!vertex.contains(j+1)) {
										vPanel.remove(vButtons[j]);
									}
								}*/
								if (!omw5.getSignal()) {

								}

								aIntegers = omw5.getPlaceAdj();
								for(int j = 0; j < max; ++j) {
									if(!aIntegers.contains(j+1)) {
										vPanel.remove(vButtons[j]);
									}
								}
								AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
								AllPathFrame.getContentPane().remove(view5);
								//view5 = omw5.getview5er();
								AllPathFrame.add(view5);
								AllPathFrame.repaint();
								AllPathFrame.revalidate();
								//AllPathFrame.pack();
								//AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								//AllPathFrame.setVisible(true);
								//frame.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});

		}

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					omw5.addOption(0, i3);
					for(int j = 0; j < max; ++j) {
						if(vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
						vPanel.add(vButtons[j]);

					}
					vertex = omw5.getVertex();
					for(int j = 0; j < max; ++j) {
						if(!vertex.contains(j+1)) {
							vPanel.remove(vButtons[j]);
						}
					}
					AllPathFrame.getContentPane().add(vPanelScoll, BorderLayout.SOUTH);
					AllPathFrame.getContentPane().remove(view5);
					//view = omw4.getViewer();
					AllPathFrame.add(view5);
					AllPathFrame.repaint();
					AllPathFrame.revalidate();
					//AllPathFrame.pack();
					//AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//AllPathFrame.setVisible(true);
					//frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				omw5.clear();
				for(int j = 0; j < max; ++j) {
					if(vertex.contains(j+1)) {
						vPanel.remove(vButtons[j]);
					}
					vPanel.add(vButtons[j]);
				}
				AllPathFrame.getContentPane().add(vPanel, BorderLayout.SOUTH);
				AllPathFrame.getContentPane().remove(view5);
				//view5 = omw5.getview5er();
				AllPathFrame.add(view5);
				AllPathFrame.pack();
				AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				AllPathFrame.setVisible(true);
				frame.dispose();
			}
		});

//		AllPathFrame.add(menuBar);
		AllPathFrame.pack();
		AllPathFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AllPathFrame.setVisible(true);
		frame.dispose();

	}
	protected static void AutoGo(){
//		// TODO Auto-generate method stub
//		JFrame AutoFrame = new JFrame ("Auto");
//		AutoFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		AutoFrame.getContentPane().setLayout(new GridBagLayout());
//
//		JPanel Option = new JPanel();
//		JButton Stop = new JButton("Stop");
//		JButton Menu = new JButton("Menu");
//		JTextField textNode = new JTextField(3);
//		JLabel enterNode = new JLabel("Beginning Node");
//		JButton Finish = new JButton("Finish");
//		JButton Clear = new JButton("Clear");
//		Menu.setBounds(10, 10, 208, 29);
//		Menu.setBackground(Color.CYAN);
//
//		Option.add(Menu);
//		Option.add(Stop);
//		Option.add(enterNode);
//		Option.add(textNode);
//		Option.add(Finish);
//		Option.add(Clear);
//
//		AutoFrame.setTitle("Auto");
//		AutoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//		GridBagConstraints c = new GridBagConstraints();
//		GridBagConstraints gc = new GridBagConstraints();
//		GridBagConstraints p = new GridBagConstraints();
//
//		JScrollPane textScroll = new JScrollPane();
//		JTextArea textArea = new JTextArea();
//		textScroll.setViewportView(textArea);
//		textArea.setText("Random Path:\n");
//		textArea.setLineWrap(true);
//		textArea.setWrapStyleWord(true);
//
//		p.fill = GridBagConstraints.BOTH;
//		p.weightx = 0.5;
//		p.gridx = 0;
//		p.gridy = 1;
//		p.ipady = 10;
//		p.anchor = GridBagConstraints.WEST;
//		AutoFrame.getContentPane().add(textScroll, p);
//
//		gc.fill = GridBagConstraints.BOTH;
//		gc.weightx = 0.5;
//		gc.gridx = 1;
//		gc.gridy = 1;
//		gc.ipadx = 100;
//		gc.ipady = 750;
//		gc.anchor = GridBagConstraints.EAST;
//		AutoFrame.getContentPane().add(view,gc);
//
//		c.gridx = 0;
//		c.gridy = 2;
//		c.ipadx = 30;
//		c.ipady = 40;
//		AutoFrame.getContentPane().add(Option, c);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridwidth = 2;
//		c.gridx = 1;
//		c.anchor = GridBagConstraints.PAGE_END;
//		c.anchor = GridBagConstraints.CENTER;
//
//
//		AutoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		AutoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//		Menu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							omw.clear();
//							AutoFrame.repaint();
//							AutoFrame.revalidate();
//							AutoFrame.setVisible(false);
//							frame.remove(view);
//							frame.add(view);
//							frame.repaint();
//							frame.revalidate();
//							frame.setVisible(true);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//			}
//		});
//
//		Finish.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed (ActionEvent e){
//				// TODO Auto-generated method stub
//				check=true;
//				if (graph.getNode(textNode.getText()) == null) {
//					JOptionPane.showMessageDialog(null, "Can't find node" + textNode.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
//				} else {
//					LinkedList<Integer> secAdjList[];
//					secAdjList = new LinkedList[max + 1];
//					for (int i = 1; i <= max; i++) {
//						secAdjList[i] = new LinkedList<Integer>();
//						secAdjList[i] = (LinkedList) omw.adjLists[i].clone();
//					}
//					if(omw.RandomPath!=""){
//						omw.RandomPath = omw.RandomPath+"\n";
//					}
//					omw.RandomPath = omw.RandomPath+"Random Path:" + "\n" +textNode.getText();
//					omw.graph.getNode(textNode.getText()).setAttribute("ui.style","shape:circle;fill-color: green;size: 30px;");
//					textArea.setText(omw.RandomPath);
//					new javax.swing.Timer(1500, new ActionListener(){
//						int begin =Integer.parseInt(textNode.getText());
//						int currentInt = begin;
//						int preInt;
//						Node currentNode = graph.getNode(begin - 1);
//
//						@Override
//						public void actionPerformed(ActionEvent e){
//							currentNode.setAttribute("ui.style","shape:circle;fill-color: green;size: 30px;");
//
//							if(secAdjList[currentInt].size()==0 || check == false){
//								((javax.swing.Timer) e.getSource()).stop();
//								return;
//							}
//							else{
//								omw.RandomPath = omw.RandomPath + " -> ";
//
//								Random rand = new Random();
//								int randNum = rand.nextInt(secAdjList[currentInt].size());
//
//								preInt = currentInt;
//
//								currentInt = secAdjList[currentInt].get(randNum);
//								currentNode = omw.graph.getNode(currentInt - 1);
//
//								secAdjList[preInt].remove(randNum);
//
//								String thisEdge = preInt + " " + currentInt;
//								omw.graph.getEdge(thisEdge).setAttribute("ui.style", "fill-color: purple; size: 3px;");
//
//
//								currentNode.setAttribute("ui.style", "shape:circle;fill-color: green;size: 30px;");
//
//								omw.RandomPath = omw.RandomPath + currentInt;
//								textArea.setText(omw.RandomPath);
//							}
//						}
//
//
//					}).start();
//
//					//omw.GraphAuto(Integer.parseInt(textNode.getText()));
//					//textArea.setText(textArea.getText() + omw.RandomPath);
//				}
//			}
//
//
//		});
//
//		Stop.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e){
//				check=false;
//			}
//		});
//
//		Clear.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e){
//				omw.clear();
//				AutoFrame.repaint();
//				AutoFrame.revalidate();
//				textArea.setText("Random Path:\n");
//			}
//		});
//
//		AutoFrame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent windowEvent) { // khi frame đóng, khôi phục lại đồ thị như ban đầu
//
//				textArea.setText("Random Path:\n");
//				omw.clear();
//				AutoFrame.repaint();
//				AutoFrame.revalidate();
//			}
//		});
//
//
//		AutoFrame.getContentPane().add(view, gc);
//
//		AutoFrame.pack();
//		AutoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		AutoFrame.setVisible(true);
//		frame.dispose();
	}
}
