/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class FourthEyePower
/*    */   extends AbstractPower
/*    */ {
/* 15 */   public static final String POWER_ID = KoishiMod.makeID("FourthEyePower");
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 17 */   public static final String NAME = powerStrings.NAME;
/* 18 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   private AbstractRelic relic;
/*    */   
/*    */   public FourthEyePower(AbstractCreature owner, AbstractRelic relic) {
/* 22 */     this.name = NAME;
/* 23 */     this.ID = POWER_ID;
/*    */     
/* 25 */     this.owner = owner;
/* 26 */     this.relic = relic;
/*    */     
/* 28 */     this.type = AbstractPower.PowerType.BUFF;
/* 29 */     this.isTurnBased = false;
/*    */ 
/*    */     
/* 32 */     loadRegion("focus");
/*    */     
/* 34 */     AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F, relic);
/* 35 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onVictory() {
/* 40 */     AbstractDungeon.player.loseRelic(this.relic.relicId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 46 */     this.description = DESCRIPTIONS[0];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/FourthEyePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */