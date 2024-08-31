/*    */ package Koishi.cards.Powers.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.FreudianInstinctPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class FreudianInstinct extends AbstractDefaultCard {
/* 17 */   public static final String ID = KoishiMod.makeID(FreudianInstinct.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("FreudianInstinct.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int BLOCK = 1;
/*    */   
/*    */   public FreudianInstinct() {
/* 30 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new FreudianInstinctPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 41 */     if (!this.upgraded) {
/* 42 */       upgradeName();
/* 43 */       this.isInnate = true;
/* 44 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 45 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Uncommon/FreudianInstinct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */