/*    */ package Koishi.cards.Powers.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.VengefulSpiritPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class VengefulSpirit extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(VengefulSpirit.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("VengefulSpirit.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int UPGRADED_COST = 0;
/*    */   private static final int EFFECT = 3;
/*    */   
/*    */   public VengefulSpirit() {
/* 30 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new VengefulSpiritPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 41 */     if (!this.upgraded) {
/* 42 */       upgradeName();
/* 43 */       upgradeBaseCost(0);
/* 44 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Uncommon/VengefulSpirit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */