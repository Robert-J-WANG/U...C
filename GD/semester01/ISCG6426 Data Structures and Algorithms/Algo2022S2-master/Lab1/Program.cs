using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DSA
{
    internal class Program
    {
        static void Main(string[] args)
        {
            TestRandomArrayCreation();
            DemoSearch();
            DemoSearchRecursive();
            string _input;
            do
            {
                Console.WriteLine("\n\n\tPlease enter your name (or 'e' to exit)");

                _input = Console.ReadLine();
                
                Console.WriteLine("Hello " + _input);

            } while (_input.ToLower() != "e");
            do
            {                
                Console.WriteLine("What is the size of the Array you require? (type 'e' to exit)");
                _input= Console.ReadLine();
                int.TryParse(_input, out int _size);
                

                int [] result = Utility.CreateRandomArray(_size);
                    
            }while(_input.ToLower()!="e");
        
        }
        static void TestRandomArrayCreation()
        {
            Console.WriteLine("\nCreating a Random array of 25 values");
            Console.WriteLine("====================================");
            Console.WriteLine();
            int[] _result = Utility.CreateRandomArray(25);
            Console.WriteLine("\n\nCreating a Random array of 20 values between 100 & 200");
            Console.WriteLine("====================================\n");
            _result = Utility.CreateRandomArray(25,100,200);
            string _msg = "\nCreating a Random array sorted in ascending order";
            Console.WriteLine(_msg);            
            string _underline = new string('=',_msg.Length);
            Console.WriteLine(_underline);
            Utility.CreateSortedArray(20);
            //Console.Read();
        }
        static void DemoSearch()
        {
            string Msg, Underline;
            Msg = "\n\nLet's run a demo using linear search. The array below is not sorted.";
            Underline = new string('=', Msg.Length);
            Console.WriteLine($"{Msg}\n{Underline}");
            
            int[] _arr = Utility.CreateRandomArray(20);
            SearchDemo _demo = new SearchDemo();
            Console.WriteLine("\nEnter a number to search\n");

            string strInput;
            int intInput;
            while ((strInput = Console.ReadLine()) != "e")
            {
                int.TryParse(strInput, out intInput);
                if (_demo.LinearSearch(_arr, intInput) == true)
                {
                    Console.WriteLine(strInput + " was found in the array");
                }
                else
                {
                    Console.WriteLine($"{ strInput} was not found in the array. ");
                }
            }
            Msg = "\nNow running a demo using Binary Search. The array below is sorted";
            Underline=new string('=', Msg.Length);
            Console.WriteLine($"{Msg}\n{Underline}");            

            _arr = Utility.CreateSortedArray(25);
            Console.WriteLine("\nEnter a number to search\n");
            while ((strInput = Console.ReadLine()) != "e")
            {
                int.TryParse(strInput, out intInput);
                if (_demo.BinarySearch(_arr, intInput) == true)
                {
                    Console.WriteLine(strInput + " was found in the array");
                }
                else
                {
                    Console.WriteLine($"{ strInput} was not found in the array. ");
                }
            }
        }
        static void DemoSearchRecursive()
        {
            string Msg, Underline;
            Msg = "\n\nLet's run a Recursion demo using linear search. The array below is not sorted.";
            Underline = new string('=', Msg.Length);
            Console.WriteLine($"{Msg}\n{Underline}");

            int[] _arr = Utility.CreateRandomArray(20);
            SearchDemo _demo = new SearchDemo();
            Console.WriteLine("\nEnter a number to search\n");

            string strInput;
            int intInput;
            while ((strInput = Console.ReadLine()) != "e")
            {
                int.TryParse(strInput, out intInput);
                if (_demo.LinearSearchRecursive(_arr,0, intInput) == true)
                {
                    Console.WriteLine(strInput + " was found in the array");
                }
                else
                {
                    Console.WriteLine($"{ strInput} was not found in the array. ");
                }
            }
            Msg = "\nNow running a Recursive demo using Binary Search. The array below is sorted";
            Underline = new string('=', Msg.Length);
            Console.WriteLine($"{Msg}\n{Underline}");

            _arr = Utility.CreateSortedArray(25);
            Console.WriteLine("\nEnter a number to search\n");
            while ((strInput = Console.ReadLine()) != "e")
            {
                int.TryParse(strInput, out intInput);
                if (_demo.BinarySearchRecursive(_arr,_arr.Length-1,0, intInput) == true)
                {
                    Console.WriteLine(strInput + " was found in the array");
                }
                else
                {
                    Console.WriteLine($"{ strInput} was not found in the array. ");
                }
            }
        }
    }
}
