/*    */ package Koishi.cards.Powers.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.FormlessExistencePower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class FormlessExistence extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(FormlessExistence.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("FormlessExistence.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 3;
/*    */   
/*    */   private static final int UPGRADED_COST = 2;
/*    */   private static final int EFFECT = 1;
/*    */   
/*    */   public FormlessExistence() {
/* 30 */     super(ID, IMG, 3, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     KoishiMod.runAnimation("spellB");
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new FormlessExistencePower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 43 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 49 */     if (!this.upgraded) {
/* 50 */       upgradeName();
/* 51 */       upgradeBaseCost(2);
/* 52 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Rare/FormlessExistence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */