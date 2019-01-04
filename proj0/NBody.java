public class NBody {
    /** return a double corresponding to the radius of the universe in the file */
    public static double readRadius(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /** return an array of Planets corresponding to the planets in the file */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xP, yP, xV, yV, m, img);
            planets[i] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Please input 3 arguments: T dt filename");
        } else {
            /** read needed input */
            double T = Double.parseDouble(args[0]);
            double dt = Double.parseDouble(args[1]);
            String filename = args[2];
            Planet[] planets = NBody.readPlanets(filename);
            double radius = NBody.readRadius(filename);

            /** draw the background */
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            String backgroundImgFilename = "images/starfield.jpg";
            StdDraw.picture(0, 0, backgroundImgFilename);
            StdDraw.show();
//            StdDraw.pause(2000);

            /** draw each planet in the planets array from the input data */
            for(Planet planet : planets) {
                planet.draw();
            }

            /** Creating an Animation */
            StdDraw.enableDoubleBuffering();

            /** set a loop until the time is up */
            double time = 0.0;
            while(time < T) {
                double[] xForces = new double[planets.length];
                double[] yForces = new double[planets.length];
                for(int i=0; i<planets.length; i++) {
                    xForces[i] = planets[i].calcNetForceExertedByX(planets);
                    yForces[i] = planets[i].calcNetForceExertedByY(planets);
                }
                for(int i = 0; i < planets.length; i++) {
                    planets[i].update(dt, xForces[i], yForces[i]);
                }
                StdDraw.picture(0, 0, backgroundImgFilename);
                for(Planet planet:planets) {
                    planet.draw();
                }
                StdDraw.show();
                StdDraw.pause(10);

                time += dt;

            }

            /** Printing the Universe */
            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }
        }
    }
}
