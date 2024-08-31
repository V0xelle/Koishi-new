/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ public class VengefulSpiritPower
/*    */   extends AbstractPower
/*    */ {
/* 19 */   public static final String POWER_ID = KoishiMod.makeID("VengefulSpiritPower");
/* 20 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 21 */   public static final String NAME = powerStrings.NAME;
/* 22 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public VengefulSpiritPower(AbstractCreature owner, int amount) {
/* 25 */     this.name = NAME;
/* 26 */     this.ID = POWER_ID;
/*    */     
/* 28 */     this.owner = owner;
/* 29 */     this.amount = amount;
/*    */     
/* 31 */     this.type = AbstractPower.PowerType.BUFF;
/* 32 */     this.isTurnBased = false;
/*    */     
/* 34 */     loadRegion("storm");
/*    */     
/* 36 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 41 */     if (target == this.owner && (power instanceof com.megacrit.cardcrawl.powers.IntangiblePlayerPower || power instanceof com.megacrit.cardcrawl.powers.IntangiblePower) && 
/* 42 */       !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 43 */       flash();
/* 44 */       Iterator<AbstractMonster> iterator = (AbstractDungeon.getMonsters()).monsters.iterator();
/*    */       
/* 46 */       while (iterator.hasNext()) {
/* 47 */         AbstractMonster m = iterator.next();
/* 48 */         if (!m.isDead && !m.isDying) {
/* 49 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, this.owner, (AbstractPower)new VulnerablePower((AbstractCreature)m, this.amount, false), this.amount));
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 58 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/VengefulSpiritPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */