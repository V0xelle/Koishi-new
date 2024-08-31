/*    */ package Koishi;
/*    */ 
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.brashmonkey.spriter.Animation;
/*    */ import com.brashmonkey.spriter.Mainline;
/*    */ import com.brashmonkey.spriter.Player;
/*    */ 
/*    */ public class KoishiPlayerListener implements Player.PlayerListener {
/*    */   private KoishiCharacter character;
/*    */   
/*    */   public KoishiPlayerListener(KoishiCharacter character) {
/* 12 */     this.character = character;
/*    */   }
/*    */   public void animationFinished(Animation animation) {
/* 15 */     if (animation.name.equals("downed")) {
/* 16 */       this.character.stopAnimation();
/* 17 */     } else if (!animation.name.equals("idle")) {
/* 18 */       this.character.resetAnimation();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void animationChanged(Animation var1, Animation var2) {}
/*    */   
/*    */   public void preProcess(Player var1) {}
/*    */   
/*    */   public void postProcess(Player var1) {}
/*    */   
/*    */   public void mainlineKeyChanged(Mainline.Key var1, Mainline.Key var2) {}
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/KoishiPlayerListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */