using System;
using Project_ParkingSystem;

namespace ConsoleApp1
{
    class ParkingSystem
    {
        static void Main(string[] args)
        {
            Vehicle v = new Vehicle();
            string[] types = { "Motorbike", "SUV", "Van", "Sedan" };
            Console.WriteLine("P A R K I N G   S Y S T E M");

            Console.Write("Enter your Plate Number: ");
            v.PlateNum = Console.ReadLine();

            Boolean b = true;
            while(b==true)
            {
                try
                {
                    int num = 1;
                    Console.WriteLine("Enter vehicle type: ");
                    foreach (string s in types)
                    {
                        Console.WriteLine("[" + num + "] " + s);
                        num++;
                    }
                    int select = Convert.ToInt32(Console.ReadLine());
                    v.Type = types[select - 1];
                    b = false;
                }
                catch
                {
                    Console.WriteLine("Enter a number in the list! try again");
                }
            }

            switch(v.Type)
            {
                case "Motorbike":
                    v = new Vehicle.MotorBike(v.PlateNum); break;
                case "SUV":
                    v = new Vehicle.SUV(v.PlateNum); break;
                case "Van":
                    v = new Vehicle.Van(v.PlateNum); break;
                case "Sevan":
                    v = new Vehicle.Sevan(v.PlateNum); break;
            }

            Console.Write("Enter the brand: ");
            v.Brand = Console.ReadLine();

            Console.WriteLine();
            Console.WriteLine("*****************************************************");
            Console.WriteLine("Plate No: " + v.PlateNum);
            Console.WriteLine("Type: " + v.Type);
            Console.WriteLine("Brand: " + v.Brand);
            Console.WriteLine("Park In(Date/Time): " + v.dtIn);
            Console.WriteLine("*****************************************************");
            Console.WriteLine();

            b = true;
            while (b == true)
            {
                try
                {
                Console.Write("Enter the date and time you will park out: ");
                    v.dtOut = Convert.ToDateTime(Console.ReadLine());

                    if ((!v.isNegativeMonthAndYear()) && (v.calculateParkTimeDay() >= 0 && v.calculateParkTimeHr() >= 0 && v.calculateParkTimeMin() >= 0)) {
                        Console.WriteLine("Date/Time in: " + v.dtIn);
                        Console.WriteLine("         Out: " + v.dtOut);
                        Console.WriteLine("Parking Time: " + v.calculateParkTimeDay() + " day/s & " + v.calculateParkTimeHr() + " hr/s");
                        Console.WriteLine("Amount: Php" + v.calculateAmount());
                        b = false;
                    }
                    else {
                        Console.WriteLine("Enter a present/future DATE and TIME.");
                    }
                }
                catch
                {
                    Console.WriteLine("Input the correct Date and Time.");
                }
            }
                
            Console.ReadKey();
        }
    }
}
