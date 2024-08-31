/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
/*    */ 
/*    */ public class IdleWhim extends AbstractIdCard {
/* 17 */   public static final String ID = KoishiMod.makeID(IdleWhim.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("IdleWhim.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DRAW = 3;
/*    */   private static final int UPGRADE_PLUS_DRAW = 1;
/*    */   
/*    */   public IdleWhim() {
/* 31 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.magicNumber = this.baseMagicNumber = 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     KoishiMod.runAnimation("spellCall");
/* 38 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawCardNextTurnPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 43 */     if (!this.upgraded) {
/* 44 */       upgradeName();
/* 45 */       upgradeMagicNumber(1);
/* 46 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/IdleWhim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */