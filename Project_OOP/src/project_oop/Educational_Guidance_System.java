package project_oop;

import java.util.*;
abstract class Grade_evaluation{
    abstract void gradeEva();
    abstract void graphEva();
}
class Student extends Grade_evaluation{
    Scanner s=new Scanner(System.in);
    String stu_name,gen;
    int id,age,n_sub;
    String sub_name[]={"Mathematics","Language-1","Language-2","Science","Social Science"};
    String grade[]=new String[5];
    int[] sub_marks=new int[5];
    int total,avg;
    int ms_avg,l1_l2_ss_avg,m_ss_L1_avg;
    
     
    // S  T  U  D  E  N  T     D  E  T  A  I  L  S   - - - - - - - -  - - - - - - - - - 
    void getDetails(){
          System.out.println("=> Student Details : ");
            System.out.print("\tEnter Name : ");
                     stu_name=s.nextLine();
            System.out.print("\tEnter Id : ");
                     id=s.nextInt();
            System.out.print("\tEnter Age : ");
                     age=s.nextInt();
            System.out.print("\tEnter Gender : ");
                    s.nextLine();
                     gen=s.nextLine();
    }
    // S  T  U  D  E  N  T  S      M  A  R   K  S     - - - - - - - - - - - - - - - - - 
    void getMarks(){
            n_sub=5;
            System.out.println("Enter Subject Marks out of 100 : ");
         for(int i=0;i<n_sub;i++){    
             if(i==1){
                 System.out.print("\t Enter Language -1[Hindi-1,Hindi-2 Or English Lang. & Literature ]  Selected By You :  ");
                    s.nextLine();
                    sub_name[i]=s.nextLine();
             }
             else if(i==2){
                 System.out.print("\t Enter Language -2[Other then Language-1 ]  Selected By You :  ");
                    s.nextLine();
                    sub_name[i]=s.nextLine();
             }else
                System.out.print("\t Subject "+(i+1)+" : "+sub_name[i]+"\n");
                
                System.out.print("\t\t Marks Obtained "+" : "); 
                  int m=s.nextInt();
                    sub_marks[i]=m;       
         }
    }

    // G  R  A  P  H       A  C  C  O  R  D   I  N  G       T  O       M  A  R  K  S   -   -   -   -   -   - 
    @Override
    void graphEva() {
        int[] x=Arrays.copyOf(sub_marks, n_sub);
       Arrays.sort(x);
       int i=100;
       System.out.println("=> ComparisionGraph : ");
       while(i>=0){
           switch(i){
               case 100:     System.out.print(" Excellent\t");break;
               case  80:      System.out.print("  Average\t"); break;
               case  50:      System.out.print("   Bad     \t"); break;
               case  30:      System.out.print("   Fail     \t"); break;
               default:        System.out.print("    |\t\t");
           } 
           System.out.print(i+"  \t");
            for(int j=0;j<n_sub;j++){
                 if(i<=sub_marks[j]){
                            System.out.print("##\t");
                    }
                    else{
                            System.out.print("  \t");
                    }
              }
         System.out.println();
         i-=10;
        }
       System.out.print(" \t   \tMarks\t");
       for(i=0;i<n_sub;i++){
                   System.out.print(sub_name[i].substring(0, 3)+"\t");  
       }
   }
   // G R A D E    E V A L U T A I O N   - - - - - - - - - - - - 
    @Override
    void gradeEva() {
        for(int i=0;i<n_sub;i++){
            total+=sub_marks[i];
            if(sub_marks[i]<33)grade[i]="E";
            else if(sub_marks[i]>33 && sub_marks[i]<=40)grade[i]="D";
            else if(sub_marks[i]>40 && sub_marks[i]<=50)grade[i]="C";
            else if(sub_marks[i]>50 && sub_marks[i]<=60)grade[i]="C+";
            else if(sub_marks[i]>60 && sub_marks[i]<=70)grade[i]="B";
            else if(sub_marks[i]>70 && sub_marks[i]<=80)grade[i]="B+";
            else if(sub_marks[i]>80 && sub_marks[i]<=90)grade[i]="A";
            else if(sub_marks[i]>90 && sub_marks[i]<=100)grade[i]="A+";
        }
        avg=total/n_sub;
    }
    void StreamSelection(){
        ms_avg=(sub_marks[0]+sub_marks[3]+300)/5;
        l1_l2_ss_avg=(sub_marks[1]+sub_marks[2]+sub_marks[4]+200)/5;
        m_ss_L1_avg=(sub_marks[1]+sub_marks[0]+sub_marks[4]+200)/5;
        System.out.println("\nScience : "+ms_avg+"\n Arts :  "+l1_l2_ss_avg+" \n Commerce :  "+m_ss_L1_avg);
    }
    //  D  I  S  P  L  A  Y    -  -  -  -  -  -  -  -  -  -  -  -  -  -
    void display(){
        System.out.println(("=").repeat(80));
        System.out.println((" ").repeat(25)+"Educational Guidance System\n"+("=").repeat(80));
        System.out.println("=> Student's Details : \n\n  1. ID : "+id+"\t\t\t\t2. Name : "+stu_name+"\n  3. Age : "+age+"\t\t\t\t4. Gender : "+gen);
        
        System.out.println(("=").repeat(80)+"\n=> Grade Mapping : \n");
         System.out.println("\n\t\tOut Of Marks :  "+(n_sub*100)+"\t\t Total Marks Obtained : "+total+"\n \t\t Average Marks : "+avg+"\n");
            System.out.println("\t"+"Sr.No"+" \t "+"Subject  "+"\t"+"Grade ");
        for(int i=0;i<n_sub;i++){
            System.out.println("\t"+(i+1)+".\t "+sub_name[i].substring(0, 3)+" \t\t"+grade[i]);
        }
        System.out.println();
    }
}
// M A I N   C L A S S - - - - - - - - - - 
public class Educational_Guidance_System extends Student{

    public static void main(String args[]) {
        Educational_Guidance_System obj=new Educational_Guidance_System();
        obj.getDetails();
        obj.getMarks();
        obj.gradeEva();
        obj.display();
        obj.StreamSelection();
        obj.graphEva();
    }
}