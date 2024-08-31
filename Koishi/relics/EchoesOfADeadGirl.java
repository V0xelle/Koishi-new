/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class EchoesOfADeadGirl
/*    */   extends CustomRelic
/*    */ {
/* 17 */   public static final String ID = KoishiMod.makeID("EchoesOfADeadGirl");
/*    */   
/* 19 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("EchoesOfADeadGirl.png"));
/* 20 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("EchoesOfADeadGirl.png"));
/*    */   
/*    */   private static final int ENERGY = 1;
/*    */   
/*    */   public EchoesOfADeadGirl() {
/* 25 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.RARE, AbstractRelic.LandingSound.MAGICAL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onTrigger(AbstractCreature target) {
/* 30 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 31 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(1));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 36 */     return this.DESCRIPTIONS[0];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/EchoesOfADeadGirl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */