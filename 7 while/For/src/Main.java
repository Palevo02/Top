public class Main {
    public static void main(String[] args) {
        {
            //Палочка слева направо
            int count = 8;
            int y = 0;
            int x = 0;
            while (x < count) {
                while (y < count) {
                    if (y == x) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                    y++;
                }
                x++;
                y = 0;
                System.out.println(" ");
            }
        }
        {
            // палочка справа налево
            int countY = 8;
            int countX = 8;
            int y = 0;
            int x = 0;
            while (y < countY) {
                while (x < countX) {
                    if (x == countX - 1) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                y++;
                x = 0;
                countX--;
                System.out.println(" ");
            }
        }
        {
            // заполненный треугольник прямой угол слева снизу
            int count = 8;
            int x = 0;
            int y = 0;
            while (y < count) {
                while (x < count) {
                    if (x == y || x == 0 || y == count - 1 || x < y) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                y++;
                x = 0;
                System.out.println(" ");
            }
        }
        {
            // заполненный треугольник прямой угол слева сверху
            int countY = 8;
            int countX = 8;
            int y = 0;
            int x = 0;
            while (y < countY) {
                while (x < countX) {
                    if (x == countX - 1 || y == 0 || x == 0 || x < countX) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                y++;
                x = 0;
                countX--;
                System.out.println(" ");
            }
        }
        {
            // пустой треугольник прямой угол слева снизу
            int count = 8;
            int x = 0;
            int y = 0;
            while (y < count) {
                while (x < count) {
                    if (x == y || x == 0 || y == count - 1) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                y++;
                x = 0;
                System.out.println(" ");
            }
        }
        {
            {
                // пустой треугольник прямой угол слева сверху
                int countY = 8;
                int countX = 8;
                int y = 0;
                int x = 0;
                while (y < countY) {
                    while (x < countX) {
                        if (x == countX - 1 || y == 0 || x == 0) {
                            System.out.print("*");

                        } else {
                            System.out.print(" ");
                        }
                        x++;
                    }
                    y++;
                    x = 0;
                    countX--;
                    System.out.println(" ");
                }
            }
        }
        {
            // пустой квадрат
            int count = 8;
            int x = 0;
            int y = 0;
            while (y < count) {
                while (x < count) {
                    if (y == 0 || y == count - 1 || x == 0 || x == count - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                System.out.println("");
                y++;
                x = 0;
            }
        }
        {
            // заполненный квадрат
            int count = 8;
            int x = 0;
            int y = 0;
            while (y < count) {
                while (x < count) {
                    if (x < count) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    x++;
                }
                System.out.println("");
                y++;
                x = 0;
            }
        }
        {
            {
                //
                int count = 15;

                int x = 0;
                int y = 0;
                while (y < count) {
                    while (x < count) {
                        System.out.print(" ");
                        if (x == count - y - 1) {
                            for (int z = 0; z < 2 * y +1; z++) {
                                System.out.print("*");
                            }
                            System.out.println();
                            break;
                        }
                        x++;
                    }
                    y++;
                    x = 0;
                }
            }
            {
                //
                int count = 15;

                int x = 0;
                int y = 0;
                while (y < count) {
                    while (x < count) {
                        System.out.print(" ");
                        if (x == count - y - 1) {
                            for (int z = 0; z < 2 * y +1; z++) {
                                if(z ==0 || z == 2* y || y == count-1){
                                    System.out.print("*");
                                } else {
                                    System.out.print(" ");
                                }

                            }
                            System.out.println();
                            break;
                        }
                        x++;
                    }
                    y++;
                    x = 0;
                }
            }
        }
    }
}
