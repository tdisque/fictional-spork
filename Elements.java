/*----------------------------------------------------------------------------
 * Copyright January 2020
 * Name: Elements
 * Author: Tom Disque
 * Purpose: To exercise some of the features unique to C# as opposed to C
 * 
 * Notes: I retired in 2019 after 42 years of code development, but found that
 *        I was restless after some months.  I decided I'd like to go back to
 *        coding for a few more years, but realized that my skills were too
 *        out of date.  I needed to learn C#, C++, Java, Python, Perl, and the
 *        parts of the full stack that I didn't already know.
 *        
 *        I started with C#, using the excellent book "Learn C# in one Day" 
 *        by Jamie Chan.  I knew from past experience with classes in Java
 *        that if I didn't start coding in C# right away, I would forget what
 *        I had learned, so I decided on this project.
 *        
 *        Since my bachelor in science degree was a double major in chemistry
 *        and computer science, I wanted a project that would involve both
 *        disciplines.  I also wanted To exercise some of the features unique 
 *        to C# as opposed to C.  This code is the result of that effort.
 *        
 *        The basic idea is the the player choose two elements to see if they
 *        will combine with one another; for example, hydrogen combines with
 *        oxygen to create water.  With later iterations, I will make it more
 *        complicated, such as requiring the player to provide two hydrogen
 *        atoms, one oxygen atom, and a spark of energy to cause the reaction
 *        to take place.
 *        
 *        Eventually, if all goes well, I can envision a sequel: Compounds,
 *        which would deal with reactions beyond simple elements, such as
 *        mixing sodium bicarbonate with vinegar to create sodium acetate,
 *        carbon dioxide, and water.
 *        
 *        It is my hope that high school students of chemistry and computer
 *        science will  use this code as a starting point to create more
 *        fun ways to learn.  Thus, I give my permission to any and all to
 *        copy and modify this code in any way you wish.  I would love to
 *        see a version of it using the the Unity or Unreal engines.
 *        
 ---------------------------------------------------------------------------*/

package Elements;

import java.util.Scanner;
import java.lang.*;
import java.io.*;

    /* There are many other properties that can be added for each element */
    public class Elements
    {
        int atomicNumber = 0;
        String atomicSymbol;
        String elementName;
        double atomicMass;
        String[] oxidationNumbers;

        public static void main(String[] args)
        {
            int AtomicNumber1 = 0, AtomicNumber2 = 0, leastCommonMultiple;
            int ratio1, ratio2, Combinations;
            Boolean NobleFlag;
            String errorMessage;
            Scanner Console = new Scanner(System.in);

            /*--- Instantiate 118 objects, one for each element ---*/
            Elements[] AllElements = new Elements[118];
            AllElements[0]   = new Elements(  1, "H", "Hydrogen", 1.00794, "-1, 1");
            AllElements[1]   = new Elements(  2, "He", "Helium", 4.002602, "0");
            AllElements[2]   = new Elements(  3, "Li", "Lithium", 6.941, "1");
            AllElements[3]   = new Elements(  4, "Be", "Beryllium", 9.012182, "2");
            AllElements[4]   = new Elements(  5, "B", "Boron", 10.811, "3");
            AllElements[5]   = new Elements(  6, "C", "Carbon", 12.0107, "-4, -3, -2, -1, 1, 2, 4");
            AllElements[6]   = new Elements(  7, "N", "Nitrogen", 14.0067, "-3, 3, 5");
            AllElements[7]   = new Elements(  8, "O", "Oxygen", 15.9994, "-2");
            AllElements[8]   = new Elements(  9, "F", "Fluorine", 18.9984032, "-1");
            AllElements[9]   = new Elements( 10, "Ne", "Neon", 20.1797, "0");
            AllElements[10]  = new Elements( 11, "Na", "Sodium", 22.98976928, "1");
            AllElements[11]  = new Elements( 12, "Mg", "Magnesium", 24.3050, "2");
            AllElements[12]  = new Elements( 13, "Al", "Aluminum", 26.9815386, "3");
            AllElements[13]  = new Elements( 14, "Si", "Silicon", 28.0855, "-4, 4");
            AllElements[14]  = new Elements( 15, "P", "Phosphorus", 30.973762, "-3, 3, 5");
            AllElements[15]  = new Elements( 16, "S", "Sulfur", 32.065, "-2, 2, 4, 6");
            AllElements[16]  = new Elements( 17, "Cl", "Chlorine", 35.453, "-1, 1, 3, 5, 7");
            AllElements[17]  = new Elements( 18, "Ar", "Argon", 39.948, "0");
            AllElements[18]  = new Elements( 19, "K", "Potassium", 39.0983, "1");
            AllElements[19]  = new Elements( 20, "Ca", "Calcium", 40.078, "2");
            AllElements[20]  = new Elements( 21, "Sc", "Scandium", 44.955912, "3");
            AllElements[21]  = new Elements( 22, "Ti", "Titanium", 47.867, "4");
            AllElements[22]  = new Elements( 23, "V", "Vanadium", 50.9415, "5");
            AllElements[23]  = new Elements( 24, "Cr", "Chromium", 51.9961, "3, 6");
            AllElements[24]  = new Elements( 25, "Mn", "Manganese", 54.938045, "2, 4, 7");
            AllElements[25]  = new Elements( 26, "Fe", "Iron", 55.845, "2, 3, 6");
            AllElements[26]  = new Elements( 27, "Co", "Cobalt", 58.933195, "2, 3");
            AllElements[27]  = new Elements( 28, "Ni", "Nickel", 58.6934, "2");
            AllElements[28]  = new Elements( 29, "Cu", "Copper", 63.546, "2");
            AllElements[29]  = new Elements( 30, "Zn", "Zinc", 65.38, "2");
            AllElements[30]  = new Elements( 31, "Ga", "Gallium", 69.723, "3");
            AllElements[31]  = new Elements( 32, "Ge", "Germanium", 72.64, "-4, 2, 4");
            AllElements[32]  = new Elements( 33, "As", "Arsenic", 74.92160, "-3, 3, 5");
            AllElements[33]  = new Elements( 34, "Se", "Selenium", 78.96, "-2, 2, 4, 6");
            AllElements[34]  = new Elements( 35, "Br", "Bromine", 79.904, "-1, 1, 3, 5");
            AllElements[35]  = new Elements( 36, "Kr", "Krypton", 83.798, "0");
            AllElements[36]  = new Elements( 37, "Rb", "Rubidium", 85.4678, "1");
            AllElements[37]  = new Elements( 38, "Sr", "Strontium", 87.62, "2");
            AllElements[38]  = new Elements( 39, "Y", "Yttrium", 88.90585, "3");
            AllElements[39]  = new Elements( 40, "Zr", "Zirconium", 91.224, "4");
            AllElements[40]  = new Elements( 41, "Nb", "Niobium", 92.90638, "5");
            AllElements[41]  = new Elements( 42, "Mo", "Molybdenum", 95.96, "4, 6");
            AllElements[42]  = new Elements( 43, "Tc", "Technetium", 98, "4, 7");
            AllElements[43]  = new Elements( 44, "Ru", "Ruthenium", 101.07, "3, 4");
            AllElements[44]  = new Elements( 45, "Rh", "Rhodium", 102.90550, "3");
            AllElements[45]  = new Elements( 46, "Pd", "Palladium", 106.42, "2, 4");
            AllElements[46]  = new Elements( 47, "Ag", "Silver", 107.8682, "1");
            AllElements[47]  = new Elements( 48, "Cd", "Cadmium", 112.411, "2");
            AllElements[48]  = new Elements( 49, "In", "Indium", 114.818, "3");
            AllElements[49]  = new Elements( 50, "Sn", "Tin", 118.710, "-4, 2, 4");
            AllElements[50]  = new Elements( 51, "Sb", "Antimony", 121.760, "-3, 3, 5");
            AllElements[51]  = new Elements( 52, "Te", "Tellurium", 127.60, "-2, 2, 4, 6");
            AllElements[52]  = new Elements( 53, "I", "Iodine", 126.90447, "-1, 1, 3, 5, 7");
            AllElements[53]  = new Elements( 54, "Xe", "Xenon", 131.293, "0");
            AllElements[54]  = new Elements( 55, "Cs", "Cesium", 132.9054519, "1");
            AllElements[55]  = new Elements( 56, "Ba", "Barium", 137.327, "2");
            AllElements[56]  = new Elements( 57, "La", "Lanthanum", 138.90547, "3");
            AllElements[57]  = new Elements( 58, "Ce", "Cerium", 140.116, "3, 4");
            AllElements[58]  = new Elements( 59, "Pr", "Praseodymium", 140.90765, "3");
            AllElements[59]  = new Elements( 60, "Nd", "Neodymium", 144.242, "3");
            AllElements[60]  = new Elements( 61, "Pm", "Promethium", 145, "3");
            AllElements[61]  = new Elements( 62, "Sm", "Samarium", 150.36, "3");
            AllElements[62]  = new Elements( 63, "Eu", "Europium", 151.964, "2, 3");
            AllElements[63]  = new Elements( 64, "Gd", "Gadolinium", 157.25, "3");
            AllElements[64]  = new Elements( 65, "Tb", "Terbium", 158.92535, "3");
            AllElements[65]  = new Elements( 66, "Dy", "Dysprosium", 162.500, "3");
            AllElements[66]  = new Elements( 67, "Ho", "Holmium", 164.93032, "3");
            AllElements[67]  = new Elements( 68, "Er", "Erbium", 167.259, "3");
            AllElements[68]  = new Elements( 69, "Tm", "Thulium", 168.93421, "3");
            AllElements[69]  = new Elements( 70, "Yb", "Ytterbium", 173.054, "3");
            AllElements[70]  = new Elements( 71, "Lu", "Lutetium", 174.9668, "3");
            AllElements[71]  = new Elements( 72, "Hf", "Hafnium", 178.49, "4");
            AllElements[72]  = new Elements( 73, "Ta", "Tantalum", 180.94788, "5");
            AllElements[73]  = new Elements( 74, "W", "Tungsten", 183.84, "4, 6");
            AllElements[74]  = new Elements( 75, "Re", "Rhenium", 186.207, "4");
            AllElements[75]  = new Elements( 76, "Os", "Osmium", 190.23, "4");
            AllElements[76]  = new Elements( 77, "Ir", "Iridium", 192.217, "3, 4");
            AllElements[77]  = new Elements( 78, "Pt", "Platinum", 195.084, "2, 4");
            AllElements[78]  = new Elements( 79, "Au", "Gold", 196.966569, "3");
            AllElements[79]  = new Elements( 80, "Hg", "Mercury", 200.59, "1, 2");
            AllElements[80]  = new Elements( 81, "Tl", "Thallium", 204.3833, "1, 3");
            AllElements[81]  = new Elements( 82, "Pb", "Lead", 207.2, "2, 4");
            AllElements[82]  = new Elements( 83, "Bi", "Bismuth", 208.98040, "3");
            AllElements[83]  = new Elements( 84, "Po", "Polonium", 209.0, "-2, 2, 4");
            AllElements[84]  = new Elements( 85, "At", "Astatine", 210.0, "-1, 1");
            AllElements[85]  = new Elements( 86, "Rn", "Radon", 222.0, "2");
            AllElements[86]  = new Elements( 87, "Fr", "Francium", 223.0, "1");
            AllElements[87]  = new Elements( 88, "Ra", "Radium", 226.0, "2");
            AllElements[88]  = new Elements( 89, "Ac", "Actinium", 227.0, "3");
            AllElements[89]  = new Elements( 90, "Th", "Thorium", 232.03806, "4");
            AllElements[90]  = new Elements( 91, "Pa", "Protactinium", 231.03588, "5");
            AllElements[91]  = new Elements( 92, "U", "Uranium", 238.02891, "6");
            AllElements[92]  = new Elements( 93, "Np", "Neptunium", 237.0, "5");
            AllElements[93]  = new Elements( 94, "Pu", "Plutonium", 244.0, "4");
            AllElements[94]  = new Elements( 95, "Am", "Americium", 243.0, "3");
            AllElements[95]  = new Elements( 96, "Cm", "Curium", 247.0, "3");
            AllElements[96]  = new Elements( 97, "Bk", "Berkelium", 247.0, "3");
            AllElements[97]  = new Elements( 98, "Cf", "Californium", 251.0, "3");
            AllElements[98]  = new Elements( 99, "Es", "Einsteinium", 252.0, "3");
            AllElements[99]  = new Elements(100, "Fm", "Fermium", 257.0, "3");
            AllElements[100] = new Elements(101, "Md", "Mendelevium", 258.0, "3");
            AllElements[101] = new Elements(102, "No", "Nobelium", 259.0, "2");
            AllElements[102] = new Elements(103, "Lr", "Lawrencium", 262.0, "3");
            AllElements[103] = new Elements(104, "Rf", "Rutherfordium", 267.0, "4");
            AllElements[104] = new Elements(105, "Db", "Dubnium", 268.0, "5");
            AllElements[105] = new Elements(106, "Sg", "Seaborgium", 271.0, "6");
            AllElements[106] = new Elements(107, "Bh", "Bohrium", 272.0, "7");
            AllElements[107] = new Elements(108, "Hs", "Hassium", 270.0, "8");
            AllElements[108] = new Elements(109, "Mt", "Meitnerium", 276.0, "0");
            AllElements[109] = new Elements(110, "Ds", "Darmstadtium", 281.0, "0");
            AllElements[110] = new Elements(111, "Rg", "Roentgenium", 280.0, "3, -1");
            AllElements[111] = new Elements(112, "Cn", "Copernicium", 285.0, "2");
            AllElements[112] = new Elements(113, "Nh", "Nihonium", 284.0, "1");
            AllElements[113] = new Elements(114, "Fl", "Flerovium", 289.0, "2");
            AllElements[114] = new Elements(115, "Mc", "Moscovium", 288.0, "3, 1");
            AllElements[115] = new Elements(116, "Lv", "Livermorium", 293.0, "4, 2");
            AllElements[116] = new Elements(117, "Ts", "Tennessine", 294.0, "0");
            AllElements[117] = new Elements(118, "Og", "Oganesson", 294.0, "8, 6, 4, 2");

            /*--- Main loop ---*/
            do
            {
                /* Get the atomic numbers of the two elements.  Should I ask for 
                 * names instead?  That would be more user friendly but also more
                 * typing on the part of the user.  It would also require reordering
                 * the collection above by name rather than atomic number, so that
                 * I can use a binary search to  retrieve items.
                 */
                /* If/when I learn to use the Unity or Unreal engines, I would
                 * display the periodic chart and let the user select elements 
                 * from it to be combined.  I would have a nerdy kid avatar 
                 * sitting at a lab table with a beaker in front of him/her,
                 * into which the elements would be placed to be combined.
                 * Fun special effects would ensue when we attempt to combine
                 * hydrogen with oxygen or sodium with chlorine.
                 */
                System.out.println("Please enter the atomic number of the first element: ");
                try
                {
                    AtomicNumber1 = Console.nextInt();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                if (AtomicNumber1-- < 0)
                    break;

                System.out.println("Please enter the atomic number of the second element: ");
                try
                {
                    AtomicNumber2 = Console.nextInt();
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                if (AtomicNumber2-- < 0)
                    break;

                /* Now we search for a match of the value of element 1 to
                 * the negated value of element 2.  For example, sodium (Na, +1)
                 * and chlorine (Cl, -1) combine to form table salt (NaCl). 
                 */
                NobleFlag = false;  /* Default is no noble gases */
                Combinations = 0;   /* Number of combinations of the two elements */
                for (String v1 : AllElements[AtomicNumber1].oxidationNumbers)
                {
                    int valence1 = Integer.parseInt(v1);
                    /* If either element has an oxidation state of zero, it won't
                     * combine with anything and it's time to quit.
                     */
                    if (valence1 == 0)
                    {
                        errorMessage = AllElements[AtomicNumber1].elementName +
                                       " will not combine with anything!";
                        System.out.println(errorMessage);
                        NobleFlag = true;
                        break;
                    }

                    for (String v2 : AllElements[AtomicNumber2].oxidationNumbers)
                    {
                        int valence2 = Integer.parseInt(v2);
                        if (valence2 == 0)
                        {
                            errorMessage = AllElements[AtomicNumber2].elementName +
                                       " will not combine with anything!";
                            System.out.println(errorMessage);
                            NobleFlag = true;
                            break;
                        }

                        /* One element must be positive and the other must be negative,
                         * or we will never combine to produce zero.
                         */
                        if (valence1 < 0 && valence2 < 0 ||
                            valence1 > 0 && valence2 > 0) 
                        {
                           /* No message; elements may have other oxidation states that will work */
                           continue;
                        }

                        /*------------------------------------------------------------- 
                         * Determine how many of element 1 we need to combine with
                         * element 2.
                         *-----------------------------------------------------------*/
                        leastCommonMultiple = lcm(Math.abs(valence1), Math.abs(valence2));
                        ratio1 = Math.abs(leastCommonMultiple / valence1);
                        ratio2 = Math.abs(leastCommonMultiple / valence2);

                        /*------------------------------------------------------------
                         * It is very likely that we will come up with combinations that 
                         * would never happen in real life.  I hope to eventually add
                         * properties to the elements that will help weed out the
                         * bogus combinations.
                         *-----------------------------------------------------------*/

                        System.out.printf("%d %s(%d) will combine with %d %s(%d)\n",
                            ratio1, AllElements[AtomicNumber1].elementName, valence1,
                            ratio2, AllElements[AtomicNumber2].elementName, valence2);
                        Combinations++;
                    }
                    if (NobleFlag == true) break;
                }
                /* If no valence was zero yet we got no combinations, then we are trying to
                 * combine two incompatibile elements, such as calcium and magnesium.
                 */
                if (NobleFlag == false && Combinations == 0)
                {
                    System.out.printf("%s will not combine with %s",
                        AllElements[AtomicNumber1].elementName,
                        AllElements[AtomicNumber2].elementName);

                }
            } while (AtomicNumber1 > -1);  /* ...because it gets decremented immediately on input */

            System.out.println("Elementary!");
        }

        /*--- Constructor for the Element object ---*/
        public Elements(int Number, String Symbol, String Name,
            double Mass, String oxidationNums)
        {
            atomicNumber = Number;
            atomicSymbol = Symbol;
            elementName = Name;
            atomicMass = Mass;

            /* Parse the different oxidation states */
            oxidationNumbers = oxidationNums.split(", ");
        }

        /* I found these great methods in geeksforgeeks.com */
        /* Recursive method to return greatest common denominator of a and b */ 
        static int gcd(int a, int b) 
        { 
            return (a == 0) ? b : gcd(b % a, a);  
        } 
      
        /* Method to return lowest common multiple of two numbers */
        static int lcm(int a, int b) 
        { 
            return (a*b) / gcd(a, b); 
        }
    }
