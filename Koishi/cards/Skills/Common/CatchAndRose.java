/*    */ package Koishi.cards.Skills.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ConstrictedPower;
/*    */ 
/*    */ public class CatchAndRose extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(CatchAndRose.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("CatchAndRose.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DEBUFF = 4;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 2;
/*    */   
/*    */   public CatchAndRose() {
/* 30 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     KoishiMod.runAnimation("occultAttack");
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new ConstrictedPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 42 */     if (!this.upgraded) {
/* 43 */       upgradeName();
/* 44 */       upgradeMagicNumber(2);
/* 45 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/CatchAndRose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */