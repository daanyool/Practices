using System;

namespace Project_ParkingSystem
{
    internal class Vehicle
    {
        private string plateNum, brand, vType;
        public DateTime dtIn, dtOut;
        public double flagDown, addPerHr;

        public string PlateNum
        {
            get { return plateNum; }
            set { plateNum = value; }
        }

        public string Brand
        {
            get { return brand; }
            set { brand = value; }
        }

        public string Type
        {
            get { return vType; }
            set { vType = value; }
        }

        public class MotorBike : Vehicle
        {
            public MotorBike(string plateNum)
            {
                this.plateNum = plateNum;
                dtIn = DateTime.Now;
                vType = "MotorBike";
                flagDown = 20.00;
                addPerHr = 5.00;
            }
        }

        public class SUV : Vehicle
        {
            public SUV(string plateNum)
            {
                this.plateNum = plateNum;
                dtIn = DateTime.Now;
                vType = "SUV";
                flagDown = 40.00;
                addPerHr = 20.00;
            }
        }

        public class Van : Vehicle
        {
            public Van(string plateNum)
            {
                this.plateNum = plateNum;
                dtIn = DateTime.Now;
                vType = "Van";
                flagDown = 40.00;
                addPerHr = 20.00;
            }
        }

        public class Sevan : Vehicle
        {
            public Sevan(string plateNum)
            {
                this.plateNum = plateNum;
                dtIn = DateTime.Now;
                vType = "Sevan";
                flagDown = 30.00;
                addPerHr = 20.00;
            }
        }

        public int calculateParkTimeDay()
        { 
            TimeSpan span = dtOut.Subtract(dtIn);

            return span.Days;
        }

        public int calculateParkTimeHr()
        {
            TimeSpan span = dtOut.Subtract(dtIn);

            return span.Hours;
        }

        public int calculateParkTimeMin()
        {
            TimeSpan span = dtOut.Subtract(dtIn);

            return span.Minutes;
        }

        public double calculateAmount()
        {
            double amount = 0;
            if (calculateParkTimeDay() >= 1)
            {
                amount = addPerHr * calculateParkTimeDay() * 24;
            }
            
            return amount += addPerHr * calculateParkTimeHr() + flagDown;
        }

        public Boolean isNegativeMonthAndYear()
        {
            int dtInMonth = Convert.ToInt32(dtIn.Month);
            int dtOutMonth = Convert.ToInt32(dtOut.Month);
            int dtInYr = Convert.ToInt32(dtIn.Year);
            int dtOutYr = Convert.ToInt32(dtOut.Year);

            if (dtInMonth > dtOutMonth && dtInYr > dtOutYr)
            {
                return true;
            }
            else
                return false;
        }
    }
}
