/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.HealAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class TerrorPower extends AbstractPower {
/*    */   public AbstractCreature source;
/* 14 */   public static final String POWER_ID = KoishiMod.makeID("TerrorPower");
/* 15 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 16 */   public static final String NAME = powerStrings.NAME;
/* 17 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public TerrorPower(AbstractCreature owner, AbstractCreature source, int amount) {
/* 20 */     this.name = NAME;
/* 21 */     this.ID = POWER_ID;
/*    */     
/* 23 */     this.owner = owner;
/* 24 */     this.amount = amount;
/* 25 */     this.source = source;
/*    */     
/* 27 */     this.type = AbstractPower.PowerType.DEBUFF;
/* 28 */     this.isTurnBased = false;
/*    */     
/* 30 */     loadRegion("phantasmal");
/*    */     
/* 32 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDeath() {
/* 37 */     flashWithoutSound();
/* 38 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new HealAction(this.source, this.source, this.amount));
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 43 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/TerrorPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */