#include <cstdlib>
#include <cstdio>
#include <iostream>
#include <string>
#include <cstring>
#include <vector>
using namespace std;

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
#define MAX_OXIDATION_STATES 10 // No element has more than 10 oxidation states
#define TOTAL_ELEMENTS 118
#define NOT_COMBINE_MESSAGE(element) cout << element << " will not combine with anything!" << endl

static int gcd(int a, int b);
static int lcm(int a, int b);

/* There are many other properties that can be added for each element */
class Elements
{
public:

    int atomicNumber;
    string atomicSymbol;
    string elementName;
    double atomicMass;
    int oxidationNumbers[MAX_OXIDATION_STATES];
    int oxidationNumbersTotal = 0, i = 0;

    /*--- Constructor for the Element object ---*/
    Elements(int Number, const char* Symbol, const char* Name,
             double Mass, const char *oxidationNums)
    {
        int len = strlen(oxidationNums), sign, i = 0;

        atomicNumber = Number;
        atomicSymbol = Symbol;
        elementName = Name;
        atomicMass = Mass;

        /* Parse the different oxidation states */
        while (i < len)
        {
            /* gnu C++ can't find atoi, stoi, or strtoi, even if I
             * add the '-std=c++11' switch.  Since I know each number
             * is a single digit with an optional sign, I used this
             * code instead.  It's faster anyway.
             */
            if (oxidationNums[i] == '-')
            {
                sign = -1;
                i++;
            }
            else
                sign = 1;

            oxidationNumbers[oxidationNumbersTotal++] = ( oxidationNums[i] - '0') * sign;

            /*--- Move past the digit, comma and space ---*/
            i += 3;
        }
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
};

int main()
{
    int AtomicNumber1 = 0, AtomicNumber2 = 0, leastCommonMultiple;
    int ratio1, ratio2, Combinations, valence1, valence2, v1, v2;
    string errorMessage;

    /*--- Instantiate 118 objects, one for each element ---*/
    Elements AllElements[TOTAL_ELEMENTS] =
    {
        Elements(  1, "H", "Hydrogen", 1.00794, "-1, 1"),
        Elements(  2, "He", "Helium", 4.002602, "0"),
        Elements(  3, "Li", "Lithium", 6.941, "1"),
        Elements(  4, "Be", "Beryllium", 9.012182, "2"),
        Elements(  5, "B", "Boron", 10.811, "3"),
        Elements(  6, "C", "Carbon", 12.0107, "-4, -3, -2, -1, 1, 2, 4"),
        Elements(  7, "N", "Nitrogen", 14.0067, "-3, 3, 5"),
        Elements(  8, "O", "Oxygen", 15.9994, "-2"),
        Elements(  9, "F", "Fluorine", 18.9984032, "-1"),
        Elements( 10, "Ne", "Neon", 20.1797, "0"),
        Elements( 11, "Na", "Sodium", 22.98976928, "1"),
        Elements( 12, "Mg", "Magnesium", 24.3050, "2"),
        Elements( 13, "Al", "Aluminum", 26.9815386, "3"),
        Elements( 14, "Si", "Silicon", 28.0855, "-4, 4"),
        Elements( 15, "P", "Phosphorus", 30.973762, "-3, 3, 5"),
        Elements( 16, "S", "Sulfur", 32.065, "-2, 2, 4, 6"),
        Elements( 17, "Cl", "Chlorine", 35.453, "-1, 1, 3, 5, 7"),
        Elements( 18, "Ar", "Argon", 39.948, "0"),
        Elements( 19, "K", "Potassium", 39.0983, "1"),
        Elements( 20, "Ca", "Calcium", 40.078, "2"),
        Elements( 21, "Sc", "Scandium", 44.955912, "3"),
        Elements( 22, "Ti", "Titanium", 47.867, "4"),
        Elements( 23, "V", "Vanadium", 50.9415, "5"),
        Elements( 24, "Cr", "Chromium", 51.9961, "3, 6"),
        Elements( 25, "Mn", "Manganese", 54.938045, "2, 4, 7"),
        Elements( 26, "Fe", "Iron", 55.845, "2, 3, 6"),
        Elements( 27, "Co", "Cobalt", 58.933195, "2, 3"),
        Elements( 28, "Ni", "Nickel", 58.6934, "2"),
        Elements( 29, "Cu", "Copper", 63.546, "2"),
        Elements( 30, "Zn", "Zinc", 65.38, "2"),
        Elements( 31, "Ga", "Gallium", 69.723, "3"),
        Elements( 32, "Ge", "Germanium", 72.64, "-4, 2, 4"),
        Elements( 33, "As", "Arsenic", 74.92160, "-3, 3, 5"),
        Elements( 34, "Se", "Selenium", 78.96, "-2, 2, 4, 6"),
        Elements( 35, "Br", "Bromine", 79.904, "-1, 1, 3, 5"),
        Elements( 36, "Kr", "Krypton", 83.798, "0"),
        Elements( 37, "Rb", "Rubidium", 85.4678, "1"),
        Elements( 38, "Sr", "Strontium", 87.62, "2"),
        Elements( 39, "Y", "Yttrium", 88.90585, "3"),
        Elements( 40, "Zr", "Zirconium", 91.224, "4"),
        Elements( 41, "Nb", "Niobium", 92.90638, "5"),
        Elements( 42, "Mo", "Molybdenum", 95.96, "4, 6"),
        Elements( 43, "Tc", "Technetium", 98, "4, 7"),
        Elements( 44, "Ru", "Ruthenium", 101.07, "3, 4"),
        Elements( 45, "Rh", "Rhodium", 102.90550, "3"),
        Elements( 46, "Pd", "Palladium", 106.42, "2, 4"),
        Elements( 47, "Ag", "Silver", 107.8682, "1"),
        Elements( 48, "Cd", "Cadmium", 112.411, "2"),
        Elements( 49, "In", "Indium", 114.818, "3"),
        Elements( 50, "Sn", "Tin", 118.710, "-4, 2, 4"),
        Elements( 51, "Sb", "Antimony", 121.760, "-3, 3, 5"),
        Elements( 52, "Te", "Tellurium", 127.60, "-2, 2, 4, 6"),
        Elements( 53, "I", "Iodine", 126.90447, "-1, 1, 3, 5, 7"),
        Elements( 54, "Xe", "Xenon", 131.293, "0"),
        Elements( 55, "Cs", "Cesium", 132.9054519, "1"),
        Elements( 56, "Ba", "Barium", 137.327, "2"),
        Elements( 57, "La", "Lanthanum", 138.90547, "3"),
        Elements( 58, "Ce", "Cerium", 140.116, "3, 4"),
        Elements( 59, "Pr", "Praseodymium", 140.90765, "3"),
        Elements( 60, "Nd", "Neodymium", 144.242, "3"),
        Elements( 61, "Pm", "Promethium", 145, "3"),
        Elements( 62, "Sm", "Samarium", 150.36, "3"),
        Elements( 63, "Eu", "Europium", 151.964, "2, 3"),
        Elements( 64, "Gd", "Gadolinium", 157.25, "3"),
        Elements( 65, "Tb", "Terbium", 158.92535, "3"),
        Elements( 66, "Dy", "Dysprosium", 162.500, "3"),
        Elements( 67, "Ho", "Holmium", 164.93032, "3"),
        Elements( 68, "Er", "Erbium", 167.259, "3"),
        Elements( 69, "Tm", "Thulium", 168.93421, "3"),
        Elements( 70, "Yb", "Ytterbium", 173.054, "3"),
        Elements( 71, "Lu", "Lutetium", 174.9668, "3"),
        Elements( 72, "Hf", "Hafnium", 178.49, "4"),
        Elements( 73, "Ta", "Tantalum", 180.94788, "5"),
        Elements( 74, "W", "Tungsten", 183.84, "4, 6"),
        Elements( 75, "Re", "Rhenium", 186.207, "4"),
        Elements( 76, "Os", "Osmium", 190.23, "4"),
        Elements( 77, "Ir", "Iridium", 192.217, "3, 4"),
        Elements( 78, "Pt", "Platinum", 195.084, "2, 4"),
        Elements( 79, "Au", "Gold", 196.966569, "3"),
        Elements( 80, "Hg", "Mercury", 200.59, "1, 2"),
        Elements( 81, "Tl", "Thallium", 204.3833, "1, 3"),
        Elements( 82, "Pb", "Lead", 207.2, "2, 4"),
        Elements( 83, "Bi", "Bismuth", 208.98040, "3"),
        Elements( 84, "Po", "Polonium", 209.0, "-2, 2, 4"),
        Elements( 85, "At", "Astatine", 210.0, "-1, 1"),
        Elements( 86, "Rn", "Radon", 222.0, "2"),
        Elements( 87, "Fr", "Francium", 223.0, "1"),
        Elements( 88, "Ra", "Radium", 226.0, "2"),
        Elements( 89, "Ac", "Actinium", 227.0, "3"),
        Elements( 90, "Th", "Thorium", 232.03806, "4"),
        Elements( 91, "Pa", "Protactinium", 231.03588, "5"),
        Elements( 92, "U", "Uranium", 238.02891, "6"),
        Elements( 93, "Np", "Neptunium", 237.0, "5"),
        Elements( 94, "Pu", "Plutonium", 244.0, "4"),
        Elements( 95, "Am", "Americium", 243.0, "3"),
        Elements( 96, "Cm", "Curium", 247.0, "3"),
        Elements( 97, "Bk", "Berkelium", 247.0, "3"),
        Elements( 98, "Cf", "Californium", 251.0, "3"),
        Elements( 99, "Es", "Einsteinium", 252.0, "3"),
        Elements(100, "Fm", "Fermium", 257.0, "3"),
        Elements(101, "Md", "Mendelevium", 258.0, "3"),
        Elements(102, "No", "Nobelium", 259.0, "2"),
        Elements(103, "Lr", "Lawrencium", 262.0, "3"),
        Elements(104, "Rf", "Rutherfordium", 267.0, "4"),
        Elements(105, "Db", "Dubnium", 268.0, "5"),
        Elements(106, "Sg", "Seaborgium", 271.0, "6"),
        Elements(107, "Bh", "Bohrium", 272.0, "7"),
        Elements(108, "Hs", "Hassium", 270.0, "8"),
        Elements(109, "Mt", "Meitnerium", 276.0, "0"),
        Elements(110, "Ds", "Darmstadtium", 281.0, "0"),
        Elements(111, "Rg", "Roentgenium", 280.0, "3, -1"),
        Elements(112, "Cn", "Copernicium", 285.0, "2"),
        Elements(113, "Nh", "Nihonium", 284.0, "1"),
        Elements(114, "Fl", "Flerovium", 289.0, "2"),
        Elements(115, "Mc", "Moscovium", 288.0, "3, 1"),
        Elements(116, "Lv", "Livermorium", 293.0, "4, 2"),
        Elements(117, "Ts", "Tennessine", 294.0, "0"),
        Elements(118, "Og", "Oganesson", 294.0, "8, 6, 4, 2")
    };
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
        cout << "Please enter the atomic number of the first element: ";
        cin >> AtomicNumber1;
        while (cin.fail() || AtomicNumber1 > TOTAL_ELEMENTS)
        {
            cin.clear();
            cin.ignore();
            cout << "Please enter a number between 1 and " << TOTAL_ELEMENTS
                 << ", or -1 to quit" << endl;
            cin >> AtomicNumber1;
        }
        if (AtomicNumber1-- < 0)
            break;

        cout << "Please enter the atomic number of the second element: ";
        cin >> AtomicNumber2;
        while (cin.fail() || AtomicNumber2 > TOTAL_ELEMENTS)
        {
            cin.clear();
            cin.ignore();
            cout << "Please enter a number between 1 and " << TOTAL_ELEMENTS
                 << ", or -1 to quit" << endl;
            cin >> AtomicNumber2;
        }
        if (AtomicNumber2-- < 0)
            break;

        /* Now we search for a match of the value of element 1 to
         * the negated value of element 2.  For example, sodium (Na, +1)
         * and chlorine (Cl, -1) combine to form table salt (NaCl).
         */

        /* If either element has an oxidation state of zero, it won't
         * combine with anything and it's time to quit.
         * If that is the case, the first oxidationNumber will be zero.
         */
        if (AllElements[AtomicNumber1].oxidationNumbers[0] == 0)
            {
                NOT_COMBINE_MESSAGE(AllElements[AtomicNumber1].elementName);
                continue;
            }

        if (AllElements[AtomicNumber2].oxidationNumbers[0] == 0)
            {
                NOT_COMBINE_MESSAGE(AllElements[AtomicNumber2].elementName);
                continue;
            }

        Combinations = 0;   /* Number of combinations of the two elements */
        for (v1 = 0; v1 < AllElements[AtomicNumber1].oxidationNumbersTotal; v1++)
        {
          valence1 = AllElements[AtomicNumber1].oxidationNumbers[v1];

          for (v2 = 0; v2 < AllElements[AtomicNumber2].oxidationNumbersTotal; v2++)
            {
                valence2 = AllElements[AtomicNumber2].oxidationNumbers[v2];

                /* One element must be positive and the other must be negative,
                 * or we will never combine to produce zero.
                 */
                if ( (valence1 < 0 && valence2 < 0) ||
                     (valence1 > 0 && valence2 > 0) )
                {
                    /* No message; elements may have other oxidation states that will work */
                    continue;
                }

                /*-------------------------------------------------------------
                 * Determine how many of element 1 we need to combine with
                 * element 2.
                 *-----------------------------------------------------------*/
                leastCommonMultiple = lcm(abs(valence1), abs(valence2));
                ratio1 = abs(leastCommonMultiple / valence1);
                ratio2 = abs(leastCommonMultiple / valence2);

                /*------------------------------------------------------------
                 * It is very likely that we will come up with combinations that
                 * would never happen in real life.  I hope to eventually add
                 * properties to the elements that will help weed out the
                 * bogus combinations.
                 *-----------------------------------------------------------*/

                cout << ratio1 << ' ' << AllElements[AtomicNumber1].elementName
                     << '(' << valence1 << ") will combine with "
                     << ratio2 << ' ' << AllElements[AtomicNumber2].elementName
                     << '(' << valence2 << ')' << endl;
                Combinations++;
            }
        }
        /* If no valence was zero yet we got no combinations, then we are trying to
         * combine two incompatible elements, such as calcium and magnesium.
         * This should not be necessary, because we checked above for both valences
         * being positive or both negative, but it never hurts to add an
         * additional check.
         */
        if (Combinations == 0)
        {
            cout << AllElements[AtomicNumber1].elementName
                 << " will not combine with "
                 << AllElements[AtomicNumber2].elementName
                 << endl;
        }
    }
    while (AtomicNumber1 > -1);    /* ...because it gets decremented immediately on input */

    cout << "Elementary!";
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