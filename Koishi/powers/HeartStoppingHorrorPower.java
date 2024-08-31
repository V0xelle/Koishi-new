/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class HeartStoppingHorrorPower
/*    */   extends AbstractPower
/*    */ {
/* 18 */   public static final String POWER_ID = KoishiMod.makeID("HeartStoppingHorrorPower");
/* 19 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 20 */   public static final String NAME = powerStrings.NAME;
/* 21 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public HeartStoppingHorrorPower(AbstractCreature owner, int amount) {
/* 24 */     this.name = NAME;
/* 25 */     this.ID = POWER_ID;
/*    */     
/* 27 */     this.owner = owner;
/* 28 */     this.amount = amount;
/*    */     
/* 30 */     this.type = AbstractPower.PowerType.BUFF;
/* 31 */     this.isTurnBased = false;
/*    */     
/* 33 */     loadRegion("rupture");
/*    */     
/* 35 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atEndOfTurn(boolean isPlayer) {
/* 40 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 41 */     while (iterator.hasNext()) {
/* 42 */       AbstractMonster mo = iterator.next();
/* 43 */       if (mo.hasPower(TerrorPower.POWER_ID)) {
/* 44 */         flash();
/* 45 */         int damage = (mo.getPower(TerrorPower.POWER_ID)).amount;
/* 46 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)mo, new DamageInfo(this.owner, damage * this.amount, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.NONE));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 53 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/HeartStoppingHorrorPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */