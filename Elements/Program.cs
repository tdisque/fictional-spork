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

using System;

namespace Elements
{
    /* There are many other properties that can be added for each element */
    class Element
    {
        int atomicNumber;
        string atomicSymbol;
        string elementName;
        double atomicMass;
        string[] oxidationNumbers;

        static void Main(string[] args)
        {
            int AtomicNumber1 = 0, AtomicNumber2 = 0;
            int ratio1, ratio2, Combinations;
            Boolean NobleFlag;

            /*--- Instantiate 118 objects, one for each element ---*/
            Element[] AllElements = new Element[118];
            AllElements[0] = new Element(001, "H", "Hydrogen", 1.00794, "-1, 1");
            AllElements[1] = new Element(002, "He", "Helium", 4.002602, "0");
            AllElements[2] = new Element(003, "Li", "Lithium", 6.941, "1");
            AllElements[3] = new Element(004, "Be", "Beryllium", 9.012182, "2");
            AllElements[4] = new Element(005, "B", "Boron", 10.811, "3");
            AllElements[5] = new Element(006, "C", "Carbon", 12.0107, "-4, -3, -2, -1, 1, 2, 4");
            AllElements[6] = new Element(007, "N", "Nitrogen", 14.0067, "-3, 3, 5");
            AllElements[7] = new Element(008, "O", "Oxygen", 15.9994, "-2");
            AllElements[8] = new Element(009, "F", "Fluorine", 18.9984032, "-1");
            AllElements[9] = new Element(010, "Ne", "Neon", 20.1797, "0");
            AllElements[10] = new Element(011, "Na", "Sodium", 22.98976928, "1");
            AllElements[11] = new Element(012, "Mg", "Magnesium", 24.3050, "2");
            AllElements[12] = new Element(013, "Al", "Aluminum", 26.9815386, "3");
            AllElements[13] = new Element(014, "Si", "Silicon", 28.0855, "-4, 4");
            AllElements[14] = new Element(015, "P", "Phosphorus", 30.973762, "-3, 3, 5");
            AllElements[15] = new Element(016, "S", "Sulfur", 32.065, "-2, 2, 4, 6");
            AllElements[16] = new Element(017, "Cl", "Chlorine", 35.453, "-1, 1, 3, 5, 7");
            AllElements[17] = new Element(018, "Ar", "Argon", 39.948, "0");
            AllElements[18] = new Element(019, "K", "Potassium", 39.0983, "1");
            AllElements[19] = new Element(020, "Ca", "Calcium", 40.078, "2");
            AllElements[20] = new Element(021, "Sc", "Scandium", 44.955912, "3");
            AllElements[21] = new Element(022, "Ti", "Titanium", 47.867, "4");
            AllElements[22] = new Element(023, "V", "Vanadium", 50.9415, "5");
            AllElements[23] = new Element(024, "Cr", "Chromium", 51.9961, "3, 6");
            AllElements[24] = new Element(025, "Mn", "Manganese", 54.938045, "2, 4, 7");
            AllElements[25] = new Element(026, "Fe", "Iron", 55.845, "2, 3, 6");
            AllElements[26] = new Element(027, "Co", "Cobalt", 58.933195, "2, 3");
            AllElements[27] = new Element(028, "Ni", "Nickel", 58.6934, "2");
            AllElements[28] = new Element(029, "Cu", "Copper", 63.546, "2");
            AllElements[29] = new Element(030, "Zn", "Zinc", 65.38, "2");
            AllElements[30] = new Element(031, "Ga", "Gallium", 69.723, "3");
            AllElements[31] = new Element(032, "Ge", "Germanium", 72.64, "-4, 2, 4");
            AllElements[32] = new Element(033, "As", "Arsenic", 74.92160, "-3, 3, 5");
            AllElements[33] = new Element(034, "Se", "Selenium", 78.96, "-2, 2, 4, 6");
            AllElements[34] = new Element(035, "Br", "Bromine", 79.904, "-1, 1, 3, 5");
            AllElements[35] = new Element(036, "Kr", "Krypton", 83.798, "0");
            AllElements[36] = new Element(037, "Rb", "Rubidium", 85.4678, "1");
            AllElements[37] = new Element(038, "Sr", "Strontium", 87.62, "2");
            AllElements[38] = new Element(039, "Y", "Yttrium", 88.90585, "3");
            AllElements[39] = new Element(040, "Zr", "Zirconium", 91.224, "4");
            AllElements[40] = new Element(041, "Nb", "Niobium", 92.90638, "5");
            AllElements[41] = new Element(042, "Mo", "Molybdenum", 95.96, "4, 6");
            AllElements[42] = new Element(043, "Tc", "Technetium", 98, "4, 7");
            AllElements[43] = new Element(044, "Ru", "Ruthenium", 101.07, "3, 4");
            AllElements[44] = new Element(045, "Rh", "Rhodium", 102.90550, "3");
            AllElements[45] = new Element(046, "Pd", "Palladium", 106.42, "2, 4");
            AllElements[46] = new Element(047, "Ag", "Silver", 107.8682, "1");
            AllElements[47] = new Element(048, "Cd", "Cadmium", 112.411, "2");
            AllElements[48] = new Element(049, "In", "Indium", 114.818, "3");
            AllElements[49] = new Element(050, "Sn", "Tin", 118.710, "-4, 2, 4");
            AllElements[50] = new Element(051, "Sb", "Antimony", 121.760, "-3, 3, 5");
            AllElements[51] = new Element(052, "Te", "Tellurium", 127.60, "-2, 2, 4, 6");
            AllElements[52] = new Element(053, "I", "Iodine", 126.90447, "-1, 1, 3, 5, 7");
            AllElements[53] = new Element(054, "Xe", "Xenon", 131.293, "0");
            AllElements[54] = new Element(055, "Cs", "Cesium", 132.9054519, "1");
            AllElements[55] = new Element(056, "Ba", "Barium", 137.327, "2");
            AllElements[56] = new Element(057, "La", "Lanthanum", 138.90547, "3");
            AllElements[57] = new Element(058, "Ce", "Cerium", 140.116, "3, 4");
            AllElements[58] = new Element(059, "Pr", "Praseodymium", 140.90765, "3");
            AllElements[59] = new Element(060, "Nd", "Neodymium", 144.242, "3");
            AllElements[60] = new Element(061, "Pm", "Promethium", 145, "3");
            AllElements[61] = new Element(062, "Sm", "Samarium", 150.36, "3");
            AllElements[62] = new Element(063, "Eu", "Europium", 151.964, "2, 3");
            AllElements[63] = new Element(064, "Gd", "Gadolinium", 157.25, "3");
            AllElements[64] = new Element(065, "Tb", "Terbium", 158.92535, "3");
            AllElements[65] = new Element(066, "Dy", "Dysprosium", 162.500, "3");
            AllElements[66] = new Element(067, "Ho", "Holmium", 164.93032, "3");
            AllElements[67] = new Element(068, "Er", "Erbium", 167.259, "3");
            AllElements[68] = new Element(069, "Tm", "Thulium", 168.93421, "3");
            AllElements[69] = new Element(070, "Yb", "Ytterbium", 173.054, "3");
            AllElements[70] = new Element(071, "Lu", "Lutetium", 174.9668, "3");
            AllElements[71] = new Element(072, "Hf", "Hafnium", 178.49, "4");
            AllElements[72] = new Element(073, "Ta", "Tantalum", 180.94788, "5");
            AllElements[73] = new Element(074, "W", "Tungsten", 183.84, "4, 6");
            AllElements[74] = new Element(075, "Re", "Rhenium", 186.207, "4");
            AllElements[75] = new Element(076, "Os", "Osmium", 190.23, "4");
            AllElements[76] = new Element(077, "Ir", "Iridium", 192.217, "3, 4");
            AllElements[77] = new Element(078, "Pt", "Platinum", 195.084, "2, 4");
            AllElements[78] = new Element(079, "Au", "Gold", 196.966569, "3");
            AllElements[79] = new Element(080, "Hg", "Mercury", 200.59, "1, 2");
            AllElements[80] = new Element(081, "Tl", "Thallium", 204.3833, "1, 3");
            AllElements[81] = new Element(082, "Pb", "Lead", 207.2, "2, 4");
            AllElements[82] = new Element(083, "Bi", "Bismuth", 208.98040, "3");
            AllElements[83] = new Element(084, "Po", "Polonium", 209.0, "-2, 2, 4");
            AllElements[84] = new Element(085, "At", "Astatine", 210.0, "-1, 1");
            AllElements[85] = new Element(086, "Rn", "Radon", 222.0, "2");
            AllElements[86] = new Element(087, "Fr", "Francium", 223.0, "1");
            AllElements[87] = new Element(088, "Ra", "Radium", 226.0, "2");
            AllElements[88] = new Element(089, "Ac", "Actinium", 227.0, "3");
            AllElements[89] = new Element(090, "Th", "Thorium", 232.03806, "4");
            AllElements[90] = new Element(091, "Pa", "Protactinium", 231.03588, "5");
            AllElements[91] = new Element(092, "U", "Uranium", 238.02891, "6");
            AllElements[92] = new Element(093, "Np", "Neptunium", 237.0, "5");
            AllElements[93] = new Element(094, "Pu", "Plutonium", 244.0, "4");
            AllElements[94] = new Element(095, "Am", "Americium", 243.0, "3");
            AllElements[95] = new Element(096, "Cm", "Curium", 247.0, "3");
            AllElements[96] = new Element(097, "Bk", "Berkelium", 247.0, "3");
            AllElements[97] = new Element(098, "Cf", "Californium", 251.0, "3");
            AllElements[98] = new Element(099, "Es", "Einsteinium", 252.0, "3");
            AllElements[99] = new Element(100, "Fm", "Fermium", 257.0, "3");
            AllElements[100] = new Element(101, "Md", "Mendelevium", 258.0, "3");
            AllElements[101] = new Element(102, "No", "Nobelium", 259.0, "2");
            AllElements[102] = new Element(103, "Lr", "Lawrencium", 262.0, "3");
            AllElements[103] = new Element(104, "Rf", "Rutherfordium", 267.0, "4");
            AllElements[104] = new Element(105, "Db", "Dubnium", 268.0, "5");
            AllElements[105] = new Element(106, "Sg", "Seaborgium", 271.0, "6");
            AllElements[106] = new Element(107, "Bh", "Bohrium", 272.0, "7");
            AllElements[107] = new Element(108, "Hs", "Hassium", 270.0, "8");
            AllElements[108] = new Element(109, "Mt", "Meitnerium", 276.0, "0");
            AllElements[109] = new Element(110, "Ds", "Darmstadtium", 281.0, "0");
            AllElements[110] = new Element(111, "Rg", "Roentgenium", 280.0, "3, -1");
            AllElements[111] = new Element(112, "Cn", "Copernicium", 285.0, "2");
            AllElements[112] = new Element(113, "Nh", "Nihonium", 284.0, "1");
            AllElements[113] = new Element(114, "Fl", "Flerovium", 289.0, "2");
            AllElements[114] = new Element(115, "Mc", "Moscovium", 288.0, "3, 1");
            AllElements[115] = new Element(116, "Lv", "Livermorium", 293.0, "4, 2");
            AllElements[116] = new Element(117, "Ts", "Tennessine", 294.0, "0");
            AllElements[117] = new Element(118, "Og", "Oganesson", 294.0, "8, 6, 4, 2");

            /*--- Main loop ---*/
            while (AtomicNumber1 >= 0)
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
                Console.Write("Please enter the atomic number of the first element: ");
                try
                {
                    AtomicNumber1 = Convert.ToInt32(Console.ReadLine());
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message + " Please try again.");
                    continue;
                }
                if (AtomicNumber1-- < 0)
                    continue;

                Console.Write("Please enter the atomic number of the second element: ");
                try
                {
                    AtomicNumber2 = Convert.ToInt32(Console.ReadLine());
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message + " Please try again.");
                    continue;
                }
                if (AtomicNumber2-- < 0)
                    continue;

                /* Now we search for a match of the value of element 1 to
                 * the negated value of element 2.  For example, sodium (Na, +1)
                 * and chlorine (Cl, -1) combine to form table salt (NaCl). 
                 */
                NobleFlag = false;  /* Default is no noble gases */
                Combinations = 0;   /* Number of combinations of the two elements */
                foreach (string v1 in AllElements[AtomicNumber1].oxidationNumbers)
                {
                    int valence1 = int.Parse(v1);
                    /* If either element has an oxidation state of zero, it won't
                     * combine with anything and it's time to quit.
                     */
                    if (valence1 == 0)
                    {
                        Console.WriteLine("{0:%s} will not combine with anything!",
                            AllElements[AtomicNumber1].elementName);
                        NobleFlag = true;
                        break;
                    }

                    foreach (string v2 in AllElements[AtomicNumber2].oxidationNumbers)
                    {
                        int valence2 = int.Parse(v2);
                        if (valence2 == 0)
                        {
                            Console.WriteLine("{0:%s} will not combine with anything!",
                                AllElements[AtomicNumber2].elementName);
                            NobleFlag = true;
                            break;
                        }

                        /* One element must be positive and the other must be negative,
                         * or we will never combine to produce zero.
                         */
                        if (valence1 < 0 && valence2 < 0 ||
                            valence1 > 0 && valence2 > 0) continue;

                        /*------------------------------------------------------------- 
                         * Determine how many of element 1 we need to combine with
                         * element 2.
                         *-----------------------------------------------------------*/
                        if (Math.Abs(valence1) > Math.Abs(valence2))
                        {
                            ratio1 = 1;
                            ratio2 = Math.Abs(valence1 / valence2);
                        }
                        else
                        {
                            ratio1 = Math.Abs(valence2 / valence1);
                            ratio2 = 1;
                        }

                        /*------------------------------------------------------------
                         * It is very likely that we will come up with combinations that 
                         * would never happen in real life.  I hope to eventually add
                         * properties to the elements that will help weed out the
                         * bogus combinations.
                         *-----------------------------------------------------------*/

                        Console.WriteLine("{0:d} {1:%s} ({2:d}) will combine with {3:d} {4:%s} ({5:d})",
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
                    Console.WriteLine("{0:%s} will not combine with {1:%s}",
                        AllElements[AtomicNumber1].elementName,
                        AllElements[AtomicNumber2].elementName);

                }
            }
            Console.WriteLine("Elementary!");
        }

        /*--- Constructor for the Element object ---*/
        public Element(int Number, string Symbol, string Name,
            double Mass, string oxidationNums)
        {
            atomicNumber = Number;
            atomicSymbol = Symbol;
            elementName = Name;
            atomicMass = Mass;

            /* Parse the different oxidation states */
            oxidationNumbers = oxidationNums.Split(",", StringSplitOptions.None);
        }
    }
}
