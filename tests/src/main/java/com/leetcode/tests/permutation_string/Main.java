package com.leetcode.tests.permutation_string;

import java.util.ArrayList;
import java.util.List;
 
class Main
{
    // Итерационная функция для генерации всех перестановок строки в Java
    // использование коллекций
    public static void findPermutations(String str)
    {
        // базовый вариант
        if (str == null || str.length() == 0) {
            return;
        }
 
        // создаем пустой ArrayList для хранения (частичных) перестановок
        List<String> partial = new ArrayList<>();
 
        // инициализируем список первым символом строки
        partial.add(String.valueOf(str.charAt(0)));
 
        // делаем для каждого символа указанной строки
        for (int i = 1; i < str.length(); i++)
        {
            // рассматриваем ранее построенные частичные перестановки одну за другой
 
            // (итерация в обратном направлении, чтобы избежать исключения ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // удалить текущую частичную перестановку из ArrayList
                String s = partial.remove(j);
 
                // Вставляем следующий символ указанной строки вообще
                // возможные позиции текущей частичной перестановки. затем
                // вставляем каждую из этих вновь созданных строк в список
 
                for (int k = 0; k <= s.length(); k++)
                {
                    // Совет: используйте StringBuilder для конкатенации
                    partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                }
            }
        }
 
        System.out.println(partial);
    }
 
    // Итерационная программа для генерации всех перестановок строки в Java
    public static void main(String[] args)
    {
        String str = "ABC";
        findPermutations(str);
    }
}