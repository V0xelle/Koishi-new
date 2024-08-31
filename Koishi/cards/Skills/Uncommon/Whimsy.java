/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.ScryAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Whimsy extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(Whimsy.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("Whimsy.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int DRAW = 1;
/*    */   private static final int UPGRADE_DRAW = 1;
/*    */   private static final int SCRY = 2;
/*    */   private static final int UPGRADE_SCRY = 1;
/*    */   
/*    */   public Whimsy() {
/* 34 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 2;
/* 37 */     this.exhaust = true;
/* 38 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("spellCall");
/* 44 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ScryAction(this.defaultSecondMagicNumber));
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 50 */     if (!this.upgraded) {
/* 51 */       upgradeName();
/* 52 */       upgradeMagicNumber(1);
/* 53 */       upgradeDefaultSecondMagicNumber(1);
/* 54 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 55 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/Whimsy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */