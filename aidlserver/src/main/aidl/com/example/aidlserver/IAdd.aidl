// IAdd.aidl
package com.example.aidlserver;
import com.example.aidlserver.Numbers;

interface IAdd {
   int addNumbers(int num1, int num2);
   int getNumbers(in Numbers num);
}