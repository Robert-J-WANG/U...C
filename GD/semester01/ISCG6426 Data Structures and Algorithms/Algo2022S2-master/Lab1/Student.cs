using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DSA
{
    public class Student
    {
        private DateTime _dob;
        private string _fname;
        private string _lname;
        private bool _gender;
        private string _address;

        public string FirstNames
        {
            get => default;
            set
            {
                _fname=value;
            }
        }

        public string LastName
        {
            get => default;
            set
            {
                _lname=value;
            }
        }

        public bool Gender
        {
            get => default;
            set
            {
            }
        }

        public DateTime DOB
        {
            get {return _dob; }
            set
            {
                _dob=value;
            }
        }

        public string Address
        {
            get => default;
            set
            {
            }
        }
    }
}