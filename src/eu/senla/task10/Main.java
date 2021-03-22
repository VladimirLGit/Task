// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task10;


public class Main {
    public static void main(String[] args) {
        WorkWithStream workWithStream = new WorkWithStream();
        workWithStream.workSplit();
        workWithStream.createCollect();
        workWithStream.filterKey();
        workWithStream.findFirstElement();
        workWithStream.findForKey();
        workWithStream.showCountCPU();
    }


}