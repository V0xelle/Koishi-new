/*    */ package Koishi.cards.Powers.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EgoPower;
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
/*    */ public class Ego extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(Ego.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("Ego.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int DRAW = 1;
/*    */   
/*    */   public Ego() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     KoishiMod.runAnimation("spellC");
/* 38 */     AbstractIdCard.idEnabled = false;
/* 39 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EgoPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 44 */     if (!this.upgraded) {
/* 45 */       upgradeName();
/* 46 */       this.isInnate = true;
/* 47 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 48 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Rare/Ego.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */