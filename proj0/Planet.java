public class Planet {
    /** Its current x position */
    public double xxPos;
    /** Its current y position */
    public double yyPos;
    /** Its current velocity in the x direction */
    public double xxVel;
    /** Its current velocity in the y direction */
    public double yyVel;
    /** Its mass */
    public double mass;
    /** The name of the file that corresponds to the image that depicts the planet */
    public String imgFileName;

    /** constructor with 6 instance variables */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    /** constructor with a Planet instance */
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxPos;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** return a double equal to the distance between the two planets */
    public double calcDistance(Planet p) {
        double x = this.xxPos - p.xxPos;
        double y = this.yyPos - p.yyPos;
        double r2 = Math.sqrt((x * x) + (y * y));
        return r2;
    }

    /** returns a double describing the force exerted on this planet by the given planet */
    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10, -11);
        double r = this.calcDistance(p);
        double f = (G * this.mass * p.mass) / (Math.pow(r, 2));
        return f;
    }

    /** return a double describing the force exerted in the X directions */
    public double calcForceExertedByX(Planet p) {
        double r = this.calcDistance(p);
        double x = p.xxPos - this.xxPos;
        double f = this.calcForceExertedBy(p);
        double fx = f * x / r;
        return fx;
    }

    /** return a double describing the force exerted in the Y directions */
    public double calcForceExertedByY(Planet p) {
        double r = this.calcDistance(p);
        double y = p.yyPos - this.yyPos;
        double f = this.calcForceExertedBy(p);
        double fy = f * y / r;
        return fy;
    }

    /** return a double X force exerted by all planets in that array upon the current Planet */
    public double calcNetForceExertedByX(Planet[] ps) {
        double nfx = 0;
        for(Planet p : ps) {
            if(this.equals(p)) {
                continue;
            } else {
                double fx = this.calcForceExertedByX(p);
                nfx += fx;
            }
        }
        return nfx;
    }

    /** return a double Y force exerted by all planets in that array upon the current Planet */
    public double calcNetForceExertedByY(Planet[] ps) {
        double nfy = 0;
        for(Planet p : ps) {
            if(this.equals(p)) {
                continue;
            } else {
                double fy = this.calcForceExertedByY(p);
                nfy += fy;
            }
        }
        return nfy;
    }

    /** update the planet’s position and velocity instance variables */
    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    /** draw the Planet’s image at the Planet’s position */
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + this.imgFileName);
    }

}
