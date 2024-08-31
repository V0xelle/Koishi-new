/*    */ package Koishi.cards.Skills.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class FleetingPhantom extends AbstractDefaultCard {
/* 17 */   public static final String ID = KoishiMod.makeID(FleetingPhantom.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("FleetingPhantom.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DRAW = 2;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DRAW = 1;
/*    */   private static final int BUFF = 1;
/*    */   
/*    */   public FleetingPhantom() {
/* 33 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 2;
/* 35 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("spellCall");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.defaultBaseSecondMagicNumber), this.defaultBaseSecondMagicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       upgradeMagicNumber(1);
/* 50 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/FleetingPhantom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */