using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DSA
{
    public class SearchDemo
    {
        public int[] _array;
        public SearchDemo()
        {
            //_array = Utility.CreateRandomArray(100);
        }
        public bool LinearSearch(int[] ThisArray,int Value)
        {
            for(int i = 0; i < ThisArray.Length; i++)
            {
                if (ThisArray[i] == Value)
                {
                    return true;
                }
            }
            return false;
        }
        public bool LinearSearchRecursive(int[] ThisArray,int Index, int Value)
        {
            if(Index>=ThisArray.Length) return false;
            if(ThisArray[Index] == Value) return true;
            return LinearSearchRecursive(ThisArray,Index+1,Value);

        }
        public bool BinarySearch(int[] ThisArray,int Value)
        {
            int Start, End, MidPoint;
            Start = 0;
            End = ThisArray.Length - 1;
            while (Start <= End)
            {
                MidPoint = (Start + End) / 2;
                if (ThisArray[MidPoint] == Value) return true;
                if (ThisArray[MidPoint] > Value)
                {
                    End = MidPoint - 1;
                }
                else
                {
                    Start = MidPoint+1;
                }
            }
            return false;
        }
        public bool BinarySearchRecursive(int[] ThisArray, int High, int Low, int Value)
        {
            if (High >= Low)
            {
                int Mid = (High + Low) / 2;
                if (ThisArray[Mid] == Value) return true;
                if (ThisArray[Mid]>Value) return BinarySearchRecursive(ThisArray,Mid-1,Low,Value);
                return BinarySearchRecursive(ThisArray, High, Mid + 1, Value);
            }
            return false ;
        }
    }
}
