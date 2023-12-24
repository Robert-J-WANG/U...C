using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DSA
{
    public static class Utility
    {
        public static int[] CreateRandomArray(int Size)
        {
            int[] _store = new int[Size];
            Random r = new Random();
            for (int i = 0; i < Size; i++)
            {
                _store[i] = r.Next(0, Size * 2);          //i*45+3/6;
            }
            //Array.Sort(_store);
            foreach (int i in _store)
            {
                Console.Write(i+", ");
            }

            return _store;
        }
        public static int[] CreateRandomArray(int Size, int Min, int Max)
        {
            int[] _store = new int[Size];
            Random r = new Random();
            for (int i = 0; i < Size; i++)
            {
                _store[i] = r.Next(Min, Max);
            }
            foreach (int i in _store)
            {
                Console.WriteLine(i);
            }

            return _store;
        }
        public static int[] CreateSortedArray(int Size)
        {
            int[] _store = new int[Size];
            Random r = new Random();
            int LastValue = 0;
            for (int i = 0; i < Size; i++)
            {
                LastValue = _store[i] = r.Next(++LastValue, LastValue+10);          //i*45+3/6;
            }
            foreach (int i in _store)
            {
                Console.Write(i+", ");
            }

            return _store;
        }
    }
}
