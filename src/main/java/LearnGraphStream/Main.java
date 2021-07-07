package LearnGraphStream;

import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("0. Thoát");
        System.out.println("1. Hiển thị đồ thị");
        System.out.println("2. TÌm đường đi từ đỉnh đầu tiên đến đỉnh cuối cùng");
        System.out.println("3. Mô phỏng đường đi bất kỳ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyGraph myGraph = new MyGraph();

        int choose = 0;
        do {
            myGraph.inputData();
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    myGraph.drawGraph();
                    break;
                case 2:
                    myGraph.simulation();
                    break;
                case 3:
                    myGraph.simulationDFS();
                    break;
                default:
                    System.out.println("Nhập lại 0 - 1 - 2 - 3");
            }
        } while (choose != 0);
    }
}
