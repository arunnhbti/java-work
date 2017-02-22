package com.arun.hackerrank.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Permission;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Do_Not_Terminate.forbidExit();
        try {
            Calculate cal = new Calculate();
            int T = cal.getINTVal();
            while (T-- > 0) {
                double volume = 0.0d;
                int ch = cal.getINTVal();
                switch (ch) {
                case 1: {
                    // Cube
                    int a = cal.getINTVal();
                    volume = Calculate.get_Vol().main(a);

                    break;
                }
                case 2: {
                    // Cuboid
                    int l = cal.getINTVal();
                    int b = cal.getINTVal();
                    int h = cal.getINTVal();
                    volume = Calculate.get_Vol().main(l, b, h);
                    break;
                }
                case 3: {
                    // Hemisphere
                    double r = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r);
                    break;
                }
                case 4: {
                    // Cylinder
                    double r = cal.getDoubleVal();
                    double h = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r, h);
                    break;
                }
                }
                cal.output.display(volume);
            }

        } catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }

    }

}

class Calculate {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<String> args = null;
    private int totalCounter = -1;
    Display output = new Display();
    static Volume volume = new Volume();

    class Display {
        public void display(double volume) {
            BigDecimal bd = new BigDecimal(volume);
            bd = bd.setScale(3, RoundingMode.HALF_UP);
            DecimalFormat format = new DecimalFormat("0.000");
            System.out.println(format.format(volume));
        }

    };

    static class Volume {
        double main(int w) {
            return Math.pow(w, 3);
        }

        double main(int l, int w, int h) {
            return l * w * h;
        }

        double main(double parR, double parH) {
            return parH * Math.PI * parR * parR;
        }

        double main(double parR) {
            return (2.0 / 3.0) * Math.PI * Math.pow(parR, 3);
        }
    }

    private enum Choice {
        one(1, Integer.class), two(3, Integer.class), three(1, Double.class), four(2, Double.class);

        private final Class<?> clazz;
        private final int noOfArgs;

        private Choice(int noOfArgs, Class<? extends Number> clazz) {
            this.noOfArgs = noOfArgs;
            this.clazz = clazz;
        }

        public static Choice getChoice(int choice) {
            return Choice.values()[choice];
        }

        @SuppressWarnings("rawtypes")
        public Class getArgClass() {
            return this.clazz;
        }

        public int getNoOfArgs() {
            return this.noOfArgs;
        }

    }

    /**
     * @return
     */
    public static Volume get_Vol() {
        return volume;
    }

    /**
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public int getINTVal() throws IOException {
        int ret = -1;
        if (args == null && totalCounter == -1) {
            String input = br.readLine();
            totalCounter = 0;
            args = new ArrayList<String>();
            int numberOfTestCases = Integer.parseInt(input);
            ret = numberOfTestCases;
            while (numberOfTestCases > 0) {
                input = br.readLine();
                args.add(input);
                totalCounter++;
                int param = Integer.parseInt(input);
                Choice choice = Choice.getChoice(param - 1);
                int counterForArgs = choice.getNoOfArgs();
                while (counterForArgs > 0) {
                    String str = br.readLine();
                    if (choice.getArgClass().isAssignableFrom(Integer.class)) {
                        args.add(str);
                        totalCounter++;
                        counterForArgs--;
                    } else if (choice.getArgClass().isAssignableFrom(Double.class)) {
                        args.add(str);
                        totalCounter++;
                        counterForArgs--;
                    }
                }
                numberOfTestCases--;
            }
            br.close();
            totalCounter = 0;
        } else {
            int intVal = Integer.parseInt(args.get(totalCounter++));
            if (intVal <= 0) {
                throw new NumberFormatException("All the values must be positive");
            }
            ret = intVal;
        }

        return ret;
    }

    public double getDoubleVal() {
        double doubleVal = Double.parseDouble(args.get(totalCounter++));
        if (doubleVal <= 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return doubleVal;
    }

}

class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}