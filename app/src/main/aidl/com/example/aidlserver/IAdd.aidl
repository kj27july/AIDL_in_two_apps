// IAdd.aidl
package com.example.aidlserver;

import com.example.aidlserver.Numbers;

// Declare any non-default types here with import statements

interface IAdd {
      int addNumbers(int num1, int num2);
         int getNumbers(in Numbers num);
}