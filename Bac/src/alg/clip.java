package alg;

public class clip {
   private String clip_code;
      private String mapx;
      private String mapy;
      private String contentid;
      private int contenttypeid;
      private int clip_stay;
      private String plan_code;
      private String path_day;
      
      public clip(String clip_code, String mapx, String mapy) {
         // TODO Auto-generated constructor stub
      }
      public String getClip_code() {
         return clip_code;
      }
      public void setClip_code(String clip_code) {
         this.clip_code = clip_code;
      }
      public String getPlan_code() {
        // TODO Auto-generated method stub
        return plan_code;
     }
     
     public void setPlan_code(String plan_code) {
        this.plan_code = plan_code;
        // TODO Auto-generated method stub
        
     }
      public String getContentid() {
            return contentid;
         }
         public void setContentid(String contentid) {
            this.contentid = contentid;
         }
         
         public int getContenttypeid() {
               return contenttypeid;
            }
            public void setContenttypeid(int contenttypeid) {
               this.contenttypeid = contenttypeid;
            }   
            
            public int getClipstay() {
                  return clip_stay;
               }
               public void setClipstay(int clip_stay) {
                  this.clip_stay = clip_stay;
               }            
         
      public String getMapx() {
         return mapx;
      }
      public void setMapx(String mapx) {
         this.mapx = mapx;
      }
      public String getMapy() {
         return mapy;
      }
      public void setMapy(String mapy) {
         this.mapy = mapy;
      }
	public int getClip_stay() {
		return clip_stay;
	}
	public void setClip_stay(int clip_stay) {
		this.clip_stay = clip_stay;
	}
	public String getPath_day() {
		return path_day;
	}
	public void setPath_day(String path_day) {
		this.path_day = path_day;
	}
	
   
}