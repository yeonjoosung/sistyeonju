package alg;

public class plan {

   private String plan_code;
   private String plan_title;
   private static int plan_period;
   private static int plan_sttime;
   private static int plan_endtime;
   private static String plan_forward;
   private static int plan_backward;
   
   public String getPlan_code() {
      return plan_code;
   }
   public void setPlan_code(String plan_code) {
      this.plan_code = plan_code;
   }
   public String getPlan_title() {
      return plan_title;
   }
   public void setPlan_title(String plan_title) {
      this.plan_title = plan_title;
   }
   
   public static int getPlan_period() {
      return plan_period;
   }
   public void setPlan_period(int plan_period) {
      plan.plan_period = plan_period;
   }
   public static int getPlan_sttime() {
      return plan_sttime;
   }
   public void setPlan_sttime(int plan_sttime) {
      plan.plan_sttime = plan_sttime;
   }
   public static int getPlan_endtime() {
      return plan_endtime;
   }
   public void setPlan_endtime(int plan_endtime) {
      plan.plan_endtime = plan_endtime;
   }
   public Object set(int i) {
      // TODO Auto-generated method stub
      return null;
   }
   public static String getPlan_forward() {
      return plan_forward;
   }
   public void setPlan_forward(String plan_forward) {
      plan.plan_forward = plan_forward;
   }
   public static int getPlan_backward() {
      return plan_backward;
   }
   public static void setPlan_backward(int plan_backward) {
      plan.plan_backward = plan_backward;
   }
   
   
   
   
   
}