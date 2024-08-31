/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class ReflexRadar extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(ReflexRadar.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("ReflexRadar.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int ENERGY_LOSS = 1;
/*    */   
/*    */   private static final int DRAW = 2;
/*    */   
/*    */   public ReflexRadar() {
/* 33 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 2;
/* 35 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("spellCall");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseEnergyAction(this.defaultSecondMagicNumber));
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 50 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 51 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/ReflexRadar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */