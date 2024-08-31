/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ 
/*    */ public class HeartbrokenPower
/*    */   extends AbstractPower
/*    */ {
/* 14 */   public static final String POWER_ID = KoishiMod.makeID("HeartbrokenPower");
/* 15 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 16 */   public static final String NAME = powerStrings.NAME;
/* 17 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public HeartbrokenPower(AbstractCreature owner, int amount) {
/* 20 */     this.name = NAME;
/* 21 */     this.ID = POWER_ID;
/*    */     
/* 23 */     this.owner = owner;
/* 24 */     this.amount = amount;
/*    */     
/* 26 */     this.type = AbstractPower.PowerType.BUFF;
/* 27 */     this.isTurnBased = false;
/*    */     
/* 29 */     loadRegion("darkembrace");
/*    */     
/* 31 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public float atDamageGive(float damage, DamageInfo.DamageType type) {
/* 36 */     if (this.owner.hasPower("IntangiblePlayer") || this.owner.hasPower("Intangible")) {
/* 37 */       return (type == DamageInfo.DamageType.NORMAL) ? (damage * (1.0F + this.amount)) : damage;
/*    */     }
/* 39 */     return damage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 45 */     this.description = DESCRIPTIONS[0] + (this.amount + 1) + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/HeartbrokenPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */